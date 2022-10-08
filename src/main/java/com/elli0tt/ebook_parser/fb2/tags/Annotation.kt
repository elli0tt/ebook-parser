package com.elli0tt.ebook_parser.fb2.tags

import com.elli0tt.ebook_parser.fb2.RequiredParamNotProvidedException

class Annotation private constructor(val id: String?, val textElements: List<TextElement>) {

    class Builder {
        private var id: String? = null
        private var textElements = arrayListOf<TextElement>()

        fun setId(id: String): Builder = apply { this.id = id }

        fun addTextElement(textElement: TextElement): Builder =
            apply { textElements += textElement }

        fun build() = Annotation(
            id,
            textElements.ifEmpty { throw RequiredParamNotProvidedException("textElements") }
        )
    }
}