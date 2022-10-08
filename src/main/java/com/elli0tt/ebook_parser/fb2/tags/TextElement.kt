package com.elli0tt.ebook_parser.fb2.tags

open class TextElement constructor(
    val id: String?,
    val style: String?,
    val subElements: List<TextSubElement>
) {

    class Builder {
        private var id: String? = null
        private var style: String? = null
        private var subElements = arrayListOf<TextSubElement>()

        fun setId(id: String): Builder = apply { this.id = id }

        fun setStyle(style: String): Builder = apply { this.style = style }

        fun addSubElement(subElement: TextSubElement): Builder = apply { subElements += subElement }

        fun build() = TextElement(
            id,
            style,
            subElements
        )
    }
}