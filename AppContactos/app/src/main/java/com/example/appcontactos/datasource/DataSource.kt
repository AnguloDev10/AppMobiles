package com.example.appcontactos.datasource

private const val MIN_RANDOM_VALUE = 0
private const val MAX_RANDOM_VALUE = 1000
private const val MIN_USER_LIST = 0
private const val MAX_USER_LIST = 100
private const val MIN_LENGTH_NAME = 0
private const val MAX_LENGTH_NAME = 10
private const val URL_PHOTO_LIST = "https://randomuser.me/api/portraits/men/number.jpg"
private const val USER_NUMBER = "number"
private const val FIRST_LETTER = 'A'
private const val LAST_LETTER = 'z'
private const val EMPTY_STRING = ""
private const val STAR_N = 9890
private const val END_N =  9998

data class UserPhoneBook(val id: Int, var name: String,val telephone: Int, var urlPhoto: String)
private fun getRandomId() = (MIN_RANDOM_VALUE..MAX_RANDOM_VALUE).random()
private fun getRandomNumber() = (STAR_N..END_N).random()
private fun getRandomName() =
    (FIRST_LETTER..LAST_LETTER).map { it }.shuffled().subList(MIN_LENGTH_NAME, MAX_LENGTH_NAME).joinToString(EMPTY_STRING)

fun loadListUsers() = mutableListOf<UserPhoneBook>().apply {
    for (i in MIN_USER_LIST..MAX_USER_LIST) {
        this.add(
            UserPhoneBook(
                id = getRandomId(),
                name = getRandomName(),
                telephone = getRandomNumber(),
                urlPhoto = URL_PHOTO_LIST.replace(USER_NUMBER, i.toString())
            )
        )
    }
}