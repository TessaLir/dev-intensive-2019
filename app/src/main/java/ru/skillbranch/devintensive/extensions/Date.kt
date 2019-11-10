package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

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

fun Date.humanizeDiff(date: Date? = null): String {
    var res: String

    val tmpDate = if (date != null) ((Date().time - date.time)) else (Date().time - this.time)

    res = when {
        tmpDate >= 0 && tmpDate < 1 * SECONDS -> "только что"
        tmpDate >= 1 * SECONDS  && tmpDate < 45 * SECONDS  -> "несколько секунд назад"
        tmpDate >= 45 * SECONDS  && tmpDate < 75 * SECONDS  -> "минуту назад"
        tmpDate >= 75 * SECONDS  && tmpDate < 45 * MINUTE -> "${tmpDate/MINUTE} минут назад"
        tmpDate >= 45 * MINUTE && tmpDate < 75 * MINUTE -> "час назад"
        tmpDate >= 75 * MINUTE && tmpDate < 22 * HOURS -> "${tmpDate/HOURS} часов назад"
        tmpDate >= 22 * HOURS && tmpDate < 26 * HOURS -> "день назад"
        tmpDate >= 26 * HOURS && tmpDate < 360 * DAY -> "${tmpDate/DAY} дней назад"
        tmpDate >= -45 * SECONDS  && tmpDate < -1 * SECONDS  -> "через несколько секунд"
        tmpDate >= -75 * SECONDS  && tmpDate < -45 * SECONDS  -> "через минуту"
        tmpDate >= -45 * MINUTE  && tmpDate < -75 * SECONDS -> "через ${tmpDate/MINUTE} минут"
        tmpDate >= -75 * MINUTE && tmpDate < -45 * MINUTE -> "через час"
        tmpDate >= -22 * HOURS && tmpDate < -75 * MINUTE -> "через ${tmpDate/HOURS} часа"
        tmpDate >= -26 * HOURS && tmpDate < -22 * HOURS -> "через день"
        tmpDate >= -360 * DAY && tmpDate < -26 * HOURS -> "через ${tmpDate/DAY} дней"
        tmpDate < -360 * DAY -> "более чем через год"
        else -> "более года назад"
    }

    return res
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
    YEAR
}
