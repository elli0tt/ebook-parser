package com.elli0tt.ebook_parser.fb2.tags

import com.elli0tt.ebook_parser.fb2.RequiredParamNotProvidedException


class P private constructor(
    id: String?,
    style: String?,
    subElements: List<TextSubElement>,
    text: String
) : TextElement(id, style, subElements, text) {

    class Builder {
        private var id: String? = null
        private var style: String? = null
        private var subElements = arrayListOf<TextSubElement>()
        private var text: String? = null

        fun setId(id: String): Builder = apply { this.id = id }

        fun setStyle(style: String): Builder = apply { this.style = style }

        fun addSubElement(subElement: TextSubElement): Builder = apply { subElements += subElement }

        fun setText(text: String): Builder = apply { this.text = text }

        fun build() = TextElement(
            id,
            style,
            subElements,
            text ?: throw RequiredParamNotProvidedException("text")
        )
    }
}