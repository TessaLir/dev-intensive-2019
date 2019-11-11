package ru.skillbranch.devintensive.extensions

fun String.truncate(substrCount: Int = 16) =
    "${if (this.trim().length <= substrCount) this.trim()
       else "${this.trim().substring(0, substrCount)}..."}"

fun String.stripHtml() = this.replace(Regex("(<.*?>)|(&[^ а-я]{1,4}?;)"), "").replace(Regex(" {2,}"), " ")