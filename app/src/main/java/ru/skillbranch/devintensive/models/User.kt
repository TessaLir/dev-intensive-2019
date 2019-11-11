package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User (
    val id:String,
    var firstName:String?,
    var lastName:String?,
    var avatar:String?,
    var rating:Int = 0,
    var respect:Int = 0,
    var lastVisit:Date? = null,
    var isOnline:Boolean = false

) {

    var introBit: String = getIntro()

    fun printMe():Unit {
        println("""
            id - $id
            firstName - $firstName
            lastName - $lastName
            avatar - $avatar
            rating - $rating
            respect - $respect
            lastVisit - $lastVisit
            isOnline - $isOnline
        """.trimIndent())
    }

    constructor(id:String, firstName:String?, lastName:String?) : this(
        id,
        firstName,
        lastName,
        null
    )

    constructor(id:String) : this(
        id,
        "John",
        "Doe"
    )

    init {
        println("It's Alive\n" +
                "${if(lastName==="Doe") "His name is" else "And his name is"} $firstName $lastName\n")
    }

    private fun getIntro() = """
        tututu???
        tututu!!!
    """.trimIndent()

    companion object Factory {
        private var lastId :Int = -1
        fun makeUser(fullName:String?) : User {
            lastId++

            val (firstName, lastName) = Utils.parseFullName(fullName)

            return User(id = "$lastId", firstName = firstName, lastName = lastName)
        }
    }

}