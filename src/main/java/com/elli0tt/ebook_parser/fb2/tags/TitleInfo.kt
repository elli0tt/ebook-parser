package com.elli0tt.ebook_parser.fb2.tags

import com.elli0tt.ebook_parser.fb2.RequiredParamNotProvidedException
import com.elli0tt.listenread.domain.parser.fb2.tags.PersonInfo

class TitleInfo private constructor(
    val genres: List<Genre>,
    val authors: List<PersonInfo>,
    val bookTitle: String,
    val annotation: Annotation?,
    val keywords: String?,
    val date: Date?,
    val coverpage: Coverpage?,
    val lang: String,
    val srcLang: String?,
    val translators: List<PersonInfo>?,
    val sequences: List<Sequence>?
) {

    class Builder {
        private var genres = arrayListOf<Genre>()
        private var authors = arrayListOf<PersonInfo>()
        private var bookTitle: String? = null
        private var annotation: Annotation? = null
        private var keywords: String? = null
        private var date: Date? = null
        private var coverpage: Coverpage? = null
        private var lang: String? = null
        private var srcLang: String? = null
        private var translators = arrayListOf<PersonInfo>()
        private var sequences = arrayListOf<Sequence>()

        fun addGenre(genre: Genre): Builder = apply { genres += genre }

        fun addAuthor(author: PersonInfo): Builder = apply { authors += author }

        fun setBookTitle(bookTitle: String): Builder = apply { this.bookTitle = bookTitle }

        fun setAnnotation(annotation: Annotation): Builder = apply { this.annotation = annotation }

        fun setKeywords(keywords: String): Builder = apply { this.keywords = keywords }

        fun setDate(date: Date): Builder = apply { this.date = date }

        fun setCoverpage(coverpage: Coverpage): Builder = apply { this.coverpage = coverpage }

        fun setLang(lang: String): Builder = apply { this.lang = lang }

        fun setSrcLang(srcLang: String): Builder = apply { this.srcLang = srcLang }

        fun addTranslator(translator: PersonInfo): Builder = apply { translators += translator }

        fun addSequence(sequence: Sequence): Builder = apply { sequences += sequence }

        fun build(): TitleInfo {
            return TitleInfo(
                genres.ifEmpty { throw RequiredParamNotProvidedException("genres") },
                authors.ifEmpty { throw RequiredParamNotProvidedException("authors") },
                bookTitle ?: throw RequiredParamNotProvidedException("bookTitle"),
                annotation,
                keywords,
                date,
                coverpage,
                lang ?: throw RequiredParamNotProvidedException("lang"),
                srcLang,
                translators,
                sequences
            )
        }
    }
}