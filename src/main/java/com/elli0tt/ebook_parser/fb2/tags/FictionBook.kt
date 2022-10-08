package com.elli0tt.ebook_parser.fb2.tags

import com.elli0tt.ebook_parser.fb2.RequiredParamNotProvidedException

class FictionBook private constructor(
    val stylesheets: List<Stylesheet>? = null,
    val description: Description,
    val bodies: List<Body>,
    val binaries: List<Binary>? = null
) {

    class Builder {
        private var stylesheets = arrayListOf<Stylesheet>()
        private var description: Description? = null
        private var bodies = arrayListOf<Body>()
        private var binaries = arrayListOf<Binary>()

        fun addStylesheet(stylesheet: Stylesheet): Builder = apply { stylesheets += stylesheet }

        fun setDescription(description: Description): Builder = apply {
            this.description = description
        }

        fun addBody(body: Body): Builder = apply { bodies += body }

        fun addBinary(binary: Binary): Builder = apply { binaries += binary }

        fun build(): FictionBook {
            return FictionBook(
                stylesheets.ifEmpty { null },
                description ?: throw RequiredParamNotProvidedException("description"),
                bodies.ifEmpty { throw RequiredParamNotProvidedException("bodies") },
                binaries.ifEmpty { null }
            )
        }
    }
}