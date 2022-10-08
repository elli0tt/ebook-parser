package com.elli0tt.listenread.domain.parser.fb2.tags

import com.elli0tt.ebook_parser.fb2.RequiredParamNotProvidedException

data class PersonInfo(
    val firstName: String?,
    val middleName: String?,
    val lastName: String?,
    val nickname: String?,
    val homePages: List<String>?,
    val emails: List<String>?,
    val id: String?
) {

    class Builder {
        private var firstName: String? = null
        private var middleName: String? = null
        private var lastName: String? = null
        private var nickname: String? = null
        private var homePages = arrayListOf<String>()
        private var emails = arrayListOf<String>()
        private var id: String? = null

        fun setFirstName(firstName: String): Builder = apply { this.firstName = firstName }

        fun setMiddleName(middleName: String): Builder = apply { this.middleName = middleName }

        fun setLastName(lastName: String): Builder = apply { this.lastName = lastName }

        fun setNickname(nickname: String): Builder = apply { this.nickname = nickname }

        fun addHomePage(homePage: String): Builder = apply { homePages += homePage }

        fun addEmail(email: String): Builder = apply { emails += email }

        fun setId(id: String): Builder = apply { this.id = id }

        fun build(): PersonInfo {
            checkAllRequiredParamsProvided()
            return PersonInfo(
                firstName,
                middleName,
                lastName,
                nickname,
                homePages.ifEmpty { null },
                emails.ifEmpty { null },
                id
            )
        }

        private fun checkAllRequiredParamsProvided() {
            if (nickname == null && (firstName == null || lastName == null)) {
                throw RequiredParamNotProvidedException("nickname, firstName, lastName")
            }
        }
    }
}