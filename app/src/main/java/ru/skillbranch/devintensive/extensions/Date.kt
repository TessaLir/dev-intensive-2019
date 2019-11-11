package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

const val SECONDS = 1000L
const val MINUTE = 60 * SECONDS
const val HOURS = 60 * MINUTE
const val DAY = 24 * HOURS
const val MONTH = 30 * DAY
const val YEAR = 365 * DAY

fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.humanizeDiff(date: Date = Date()): String {

    val tmpDate = abs(this.time - date.time)
    val isPast = this.time < date.time

    return when {
        tmpDate <= SECONDS -> "только что"
        tmpDate <= SECONDS * 45 -> if (isPast) "несколько секунд назад" else "через несколько секунд"
        tmpDate <= SECONDS * 75 -> if (isPast) "минуту назад" else "через минуту"
        tmpDate <= MINUTE * 45 -> if (isPast) "${TimeUnits.MINUTE.plural((tmpDate / MINUTE).toInt())} назад"
        else "через ${TimeUnits.MINUTE.plural((tmpDate / MINUTE).toInt())}"
        tmpDate  <= MINUTE * 75 -> if (isPast) "час назад" else "через час"
        tmpDate  <= HOURS * 22 -> if (isPast) "${TimeUnits.HOUR.plural((tmpDate / HOURS).toInt())} назад"
        else "через ${TimeUnits.HOUR.plural((tmpDate / HOURS).toInt())}"
        tmpDate  <= HOURS * 26 -> if (isPast) "день назад" else "через день"
        tmpDate  <= DAY * 360 -> if (isPast) "${TimeUnits.DAY.plural((tmpDate / DAY).toInt())} назад"
        else "через ${TimeUnits.DAY.plural((tmpDate / DAY).toInt())}"
        else -> if (isPast) "более года назад" else "более чем через год"
    }
}

fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND) : Date {
    var time = this.time

    time += when(units) {
        TimeUnits.SECOND -> value * SECONDS
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOURS
        TimeUnits.DAY -> value * DAY
        TimeUnits.MONTH -> value * MONTH
        TimeUnits.YEAR -> value * YEAR
    }

    this.time = time

    return this
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY,
    MONTH,
    YEAR;

    fun plural(value: Int): String {
        val plurals = mapOf(
            SECOND to Triple("секунду","секунды","секунд"),
            MINUTE to Triple("минуту","минуты","минут"),
            HOUR to Triple("час","часа","часов"),
            DAY to Triple("день","дня","дней")
        )

        val rem = value % 10
        val rem100 = value % 100

        return when {
            rem100 in 10..20 -> "$value ${plurals[this]?.third}"
            rem in 2..4 -> "$value ${plurals[this]?.second}"
            rem == 1 -> "$value ${plurals[this]?.first}"
            else -> "$value ${plurals[this]?.third}"
        }
    }

}
