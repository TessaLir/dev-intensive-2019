package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        var string = fullName
        if (string == "" || string == " ") string = null

        val parts : List<String>? = string?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " ") :String {
        val arr = payload.split(" ")
        val fName = getEngChar(arr[0])
        val lNmae = getEngChar(arr[1])
        return "$fName$divider$lNmae"
    }

    private fun getEngChar(s: String): Any {
        var result = ""

        for (el in s) {
            result += toChar(el)
        }

        return result
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val fName = if (firstName?.length == 0) null else firstName?.first()?.toUpperCase()
        val lName = if (lastName?.length == 0) null else lastName?.first()?.toUpperCase()
        if (fName == null || fName == ' ') return null
        return "${if(lName == null) "$fName" else "$fName$lName"}"
    }

    private fun toChar(ch: Char) = when(ch) {
        'а' -> "a"
        'б' -> "b"
        'в' -> "v"
        'г' -> "g"
        'д' -> "d"
        'е' -> "e"
        'ё' -> "e"
        'ж' -> "zh"
        'з' -> "z"
        'и' -> "i"
        'й' -> "i"
        'к' -> "k"
        'л' -> "l"
        'м' -> "m"
        'н' -> "n"
        'о' -> "o"
        'п' -> "p"
        'р' -> "r"
        'с' -> "s"
        'т' -> "t"
        'у' -> "u"
        'ф' -> "f"
        'х' -> "h"
        'ц' -> "c"
        'ч' -> "ch"
        'ш' -> "sh"
        'щ' -> "sh'"
        'ъ' -> ""
        'ы' -> "i"
        'ь' -> ""
        'э' -> "e"
        'ю' -> "yu"
        'я' -> "ya"
        'а'.toUpperCase() -> "A"
        'б'.toUpperCase() -> "B"
        'в'.toUpperCase() -> "V"
        'г'.toUpperCase() -> "G"
        'д'.toUpperCase() -> "D"
        'е'.toUpperCase() -> "E"
        'ё'.toUpperCase() -> "E"
        'ж'.toUpperCase() -> "Zh"
        'з'.toUpperCase() -> "Z"
        'и'.toUpperCase() -> "I"
        'й'.toUpperCase() -> "I"
        'к'.toUpperCase() -> "K"
        'л'.toUpperCase() -> "L"
        'м'.toUpperCase() -> "M"
        'н'.toUpperCase() -> "N"
        'о'.toUpperCase() -> "O"
        'п'.toUpperCase() -> "P"
        'р'.toUpperCase() -> "R"
        'с'.toUpperCase() -> "S"
        'т'.toUpperCase() -> "T"
        'у'.toUpperCase() -> "U"
        'ф'.toUpperCase() -> "F"
        'х'.toUpperCase() -> "H"
        'ц'.toUpperCase() -> "C"
        'ч'.toUpperCase() -> "Ch"
        'ш'.toUpperCase() -> "Sh"
        'щ'.toUpperCase() -> "Sh'"
        'ъ'.toUpperCase() -> ""
        'ы'.toUpperCase() -> "I"
        'ь'.toUpperCase() -> ""
        'э'.toUpperCase() -> "E"
        'ю'.toUpperCase() -> "Yu"
        'я'.toUpperCase() -> "Ya"
        else -> ch
    }
}