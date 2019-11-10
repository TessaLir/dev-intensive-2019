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
        val arr = payload.split(divider)
        val fName = getEngChar(arr[0])
        val lNmae = getEngChar(arr[1])
        return "${fName}$divider$lNmae"
    }

    private fun getEngChar(s: String): Any {
        var result = ""

        for (el in s) {
            result += toChar(el)
        }

        return result
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val fName = if (firstName?.length == 0) null else firstName?.first()
        val lName = if (lastName?.length == 0) null else lastName?.first()
        return "${if(fName == null) null
                  else if(fName.equals(' ')) null
                  else if(lName == null) "$fName" else "$fName$lName"}"
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
        'а'.toUpperCase() -> "a".toUpperCase()
        'б'.toUpperCase() -> "b".toUpperCase()
        'в'.toUpperCase() -> "v".toUpperCase()
        'г'.toUpperCase() -> "g".toUpperCase()
        'д'.toUpperCase() -> "d".toUpperCase()
        'е'.toUpperCase() -> "e".toUpperCase()
        'ё'.toUpperCase() -> "e".toUpperCase()
        'ж'.toUpperCase() -> "zh".toUpperCase()
        'з'.toUpperCase() -> "z".toUpperCase()
        'и'.toUpperCase() -> "i".toUpperCase()
        'й'.toUpperCase() -> "i".toUpperCase()
        'к'.toUpperCase() -> "k".toUpperCase()
        'л'.toUpperCase() -> "l".toUpperCase()
        'м'.toUpperCase() -> "m".toUpperCase()
        'н'.toUpperCase() -> "n".toUpperCase()
        'о'.toUpperCase() -> "o".toUpperCase()
        'п'.toUpperCase() -> "p".toUpperCase()
        'р'.toUpperCase() -> "r".toUpperCase()
        'с'.toUpperCase() -> "s".toUpperCase()
        'т'.toUpperCase() -> "t".toUpperCase()
        'у'.toUpperCase() -> "u".toUpperCase()
        'ф'.toUpperCase() -> "f".toUpperCase()
        'х'.toUpperCase() -> "h".toUpperCase()
        'ц'.toUpperCase() -> "c".toUpperCase()
        'ч'.toUpperCase() -> "ch".toUpperCase()
        'ш'.toUpperCase() -> "sh".toUpperCase()
        'щ'.toUpperCase() -> "sh'".toUpperCase()
        'ъ'.toUpperCase() -> "".toUpperCase()
        'ы'.toUpperCase() -> "i".toUpperCase()
        'ь'.toUpperCase() -> "".toUpperCase()
        'э'.toUpperCase() -> "e".toUpperCase()
        'ю'.toUpperCase() -> "yu".toUpperCase()
        'я'.toUpperCase() -> "ya".toUpperCase()
        else -> "_"
    }
}