package com.elli0tt.ebook_parser.fb2

import android.util.Log
import android.util.Xml
import com.elli0tt.ebook_parser.fb2.tags.*
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.InputStream

class Fb2Parser : Parser {

    private lateinit var xmlParser: XmlPullParser

    suspend fun parseBook(inputStream: InputStream) {
//        printAllTags(inputStream)

        xmlParser = XmlPullParserFactory.newInstance().newPullParser()
        xmlParser.setInput(inputStream, null)
        xmlParser.nextTag()

        val fictionBookBuilder = FictionBook.Builder()
        parseRoot(fictionBookBuilder)

//        val fb2Book = fb2BookBuilder.build()
    }

    private fun parseRoot(fictionBookBuilder: FictionBook.Builder) {
        Log.d(TAG, "parseRoot()")
        xmlParser.checkStartsWithTag(ROOT_TAG)
        parseChildrenTags { tagName ->
            when (tagName) {
                STYLESHEET_TAG -> parseStyleSheet(fictionBookBuilder)
                DESCRIPTION_TAG -> parseDescription(fictionBookBuilder)
                BODY_TAG -> parseBody(fictionBookBuilder)
                BINARY_TAG -> parseBinary(fictionBookBuilder)
            }
        }
    }

    private fun parseChildrenTags(tagsHandler: (tagName: String) -> Unit) {
        while (xmlParser.next() != XmlPullParser.END_TAG) {
            if (xmlParser.eventType != XmlPullParser.START_TAG) {
                continue
            }
            tagsHandler.invoke(xmlParser.name)
        }
    }

    private fun parseStyleSheet(fictionBookBuilder: FictionBook.Builder) {
        Log.d(TAG, "parseStyleSheet()")
        xmlParser.checkStartsWithTag(STYLESHEET_TAG)
        parseChildrenTags { tagName ->

        }
    }

    private fun parseDescription(fictionBookBuilder: FictionBook.Builder) {
        Log.d(TAG, "parseDescription()")
        xmlParser.checkStartsWithTag(DESCRIPTION_TAG)
        val descriptionBuilder = Description.Builder()
        parseChildrenTags { tagName ->
            when (tagName) {
                TITLE_INFO_TAG -> parseTitleInfo(descriptionBuilder)
                SRC_TITLE_INFO_TAG -> parseSrcTitleInfo(descriptionBuilder)
                DOCUMENT_INFO_TAG -> parseDocumentInfo(descriptionBuilder)
                PUBLISH_INFO_TAG -> parsePublishInfo(descriptionBuilder)
                CUSTOM_INFO_TAG -> parseCustomInfo(descriptionBuilder)
                OUTPUT_INFO_TAG -> parseOutput(descriptionBuilder)
            }
        }
//        fb2BookBuilder.setDescription(descriptionBuilder.build())
    }

    private fun parseBody(fictionBookBuilder: FictionBook.Builder) {
        Log.d(TAG, "parseBody()")
        xmlParser.checkStartsWithTag(BODY_TAG)
        parseChildrenTags { tagName ->

        }
    }

    private fun parseBinary(fictionBookBuilder: FictionBook.Builder) {
        Log.d(TAG, "parseBinary()")
        xmlParser.checkStartsWithTag(BINARY_TAG)
        parseChildrenTags { tagName ->

        }
    }

    private fun parseTitleInfo(descriptionBuilder: Description.Builder) {
        Log.d(TAG, "parseTitleInfo()")
        xmlParser.checkStartsWithTag(TITLE_INFO_TAG)
        parseChildrenTags { tagName ->
            when (tagName) {
                GENRE_TAG -> parseGenre()
                AUTHOR_TAG -> parseAuthor()
                BOOK_TITLE_TAG -> parseBookTitle()
                ANNOTATION_TAG -> parseAnnotation()
                KEYWORDS_TAG -> parseKeywords()
                DATE_TAG -> parseDate()
                COVERPAGE_TAG -> parseCoverpage()
                LANG_TAG -> parseLang()
                SRC_LANG_TAG -> parseSrcLang()
                TRANSLATOR_TAG -> parseTranslator()
                SEQUENCE_TAG -> parseSequence()
            }
        }
        Log.d(TAG, "parseTitleInfo() finish")
    }

    private fun parseSrcTitleInfo(descriptionBuilder: Description.Builder) {
        Log.d(TAG, "parseSrcTitleInfo()")
        xmlParser.checkStartsWithTag(SRC_TITLE_INFO_TAG)
        parseChildrenTags { tagName ->

        }
    }

    private fun parseDocumentInfo(descriptionBuilder: Description.Builder) {
        Log.d(TAG, "parseDocumentInfo()")
        xmlParser.checkStartsWithTag(DOCUMENT_INFO_TAG)
        parseChildrenTags { tagName ->

        }
    }

    private fun parsePublishInfo(descriptionBuilder: Description.Builder) {
        Log.d(TAG, "parsePublishInfo()")
        xmlParser.checkStartsWithTag(PUBLISH_INFO_TAG)
        parseChildrenTags { tagName ->

        }
    }

    private fun parseCustomInfo(descriptionBuilder: Description.Builder) {
        Log.d(TAG, "parseCustomInfo()")
        xmlParser.checkStartsWithTag(CUSTOM_INFO_TAG)
        parseChildrenTags { tagName ->

        }
    }

    private fun parseOutput(descriptionBuilder: Description.Builder) {
        Log.d(TAG, "parseOutput()")
        xmlParser.checkStartsWithTag(OUTPUT_INFO_TAG)
        parseChildrenTags { tagName ->

        }
    }

    private fun parseGenre() {
        Log.d(TAG, "parseGenre()")
        xmlParser.checkStartsWithTag(GENRE_TAG)
        parseChildrenTags { tagName ->

        }
    }

    private fun parseAuthor() {
        Log.d(TAG, "parseAuthor()")
        xmlParser.checkStartsWithTag(AUTHOR_TAG)
        parseChildrenTags { tagName ->
            when (tagName) {
                FIRST_NAME_TAG -> parseFirstName()
                MIDDLE_NAME_TAG -> parseMiddleName()
                LAST_NAME_TAG -> parseLastName()
            }
        }
    }

    private fun parseBookTitle() {
        Log.d(TAG, "parseBookTitle()")
        xmlParser.checkStartsWithTag(BOOK_TITLE_TAG)
        parseChildrenTags { tagName ->

        }
    }

    private fun parseAnnotation() {
        Log.d(TAG, "parseAnnotation()")
        xmlParser.checkStartsWithTag(ANNOTATION_TAG)
        parseChildrenTags { tagName ->
            when (tagName) {
                P_TAG -> parseP()
            }
        }
    }

    private fun parseKeywords() {
        Log.d(TAG, "parseKeywords()")
        xmlParser.checkStartsWithTag(KEYWORDS_TAG)
        parseChildrenTags { tagName ->

        }
    }

    private fun parseDate() {
        Log.d(TAG, "parseDate()")
        xmlParser.checkStartsWithTag(DATE_TAG)
        parseChildrenTags { tagName ->

        }
    }

    private fun parseCoverpage() {
        Log.d(TAG, "parseCoverpage()")
        xmlParser.checkStartsWithTag(COVERPAGE_TAG)
        parseChildrenTags { tagName ->

        }
    }

    private fun parseLang() {
        Log.d(TAG, "parseLang()")
        xmlParser.checkStartsWithTag(LANG_TAG)
        parseChildrenTags { tagName ->

        }
    }

    private fun parseSrcLang() {
        Log.d(TAG, "parseSrcLang()")
        xmlParser.checkStartsWithTag(SRC_LANG_TAG)
        parseChildrenTags { tagName ->

        }
    }

    private fun parseTranslator() {
        Log.d(TAG, "parseTranslator()")
        xmlParser.checkStartsWithTag(TRANSLATOR_TAG)
        parseChildrenTags { tagName ->

        }
    }

    private fun parseSequence() {
        Log.d(TAG, "parseSequence()")
        xmlParser.checkStartsWithTag(SEQUENCE_TAG)
        parseChildrenTags { tagName ->

        }
    }

    private fun parseFirstName() {
        Log.d(TAG, "parseFirstName()")
        xmlParser.checkStartsWithTag(FIRST_NAME_TAG)
        parseChildrenTags { tagName ->

        }
    }

    private fun parseMiddleName() {
        Log.d(TAG, "parseMiddleName()")
        xmlParser.checkStartsWithTag(MIDDLE_NAME_TAG)
        parseChildrenTags { tagName ->

        }
    }

    private fun parseLastName() {
        Log.d(TAG, "parseLastName()")
        xmlParser.checkStartsWithTag(LAST_NAME_TAG)
        parseChildrenTags { tagName ->

        }
    }

    private fun parseP() {
        Log.d(TAG, "parseP()")
        xmlParser.checkStartsWithTag(P_TAG)
//        Log.d(TAG, "p: text: ${xmlParser.text}")
        val pBuilder = P.Builder()
        while (xmlParser.next() != XmlPullParser.END_TAG && xmlParser.name != P_TAG) {
            if (xmlParser.eventType == XmlPullParser.START_TAG) {
                when (xmlParser.name) {
                    STRONG_TAG -> parseStrong(pBuilder)
                }
            }
            if  (xmlParser.eventType == XmlPullParser.TEXT) {
                pBuilder.addSubElement(Text(xmlParser.text))
            }
        }
        val p = pBuilder.build()
        Log.d(TAG, "p subelements: ${p.subElements.joinToString(separator = "|||")}")
    }

    private fun parseStrong(pBuilder: P.Builder) {
        Log.d(TAG, "parseStrong()")
        xmlParser.checkStartsWithTag(STRONG_TAG)
        while (xmlParser.next() != XmlPullParser.END_TAG && xmlParser.name != STRONG_TAG) {
            pBuilder.addSubElement(Strong(xmlParser.text))
        }
    }

    private fun printAllTags(inputStream: InputStream) {
        inputStream.use { stream ->
            val parser = Xml.newPullParser()
            parser.setInput(stream, null)

            while (parser.eventType != XmlPullParser.END_DOCUMENT) {
                when (parser.eventType) {
                    XmlPullParser.START_DOCUMENT -> {
                        Log.d(TAG, "XmlPullParser.START_DOCUMENT")
                    }
                    XmlPullParser.END_DOCUMENT -> {
                        Log.d(TAG, "XmlPullParser.END_DOCUMENT")
                    }
                    XmlPullParser.START_TAG -> {
                        Log.d(
                            TAG,
                            "XmlPullParser.START_TAG: " +
                                    "name: ${parser.name}, " +
                                    "attributeCount: ${parser.attributeCount}, " +
                                    "columnNumber: ${parser.columnNumber}, " +
                                    "text: ${parser.text}, " +
                                    "depth: ${parser.depth}"
                        )
                    }
                    XmlPullParser.END_TAG -> {
                        Log.d(TAG, "XmlPullParser.END_TAG: ${parser.name}")
                    }
                    XmlPullParser.TEXT -> {
                        Log.d(TAG, "XmlPullParser.TEXT: ${parser.text}")
                    }
                }
                parser.next()
            }
        }
    }

    companion object {
        private const val TAG = "Fb2Parser"

        private const val ROOT_TAG = "FictionBook"

        private const val STYLESHEET_TAG = "stylesheet"
        private const val DESCRIPTION_TAG = "description"
        private const val BODY_TAG = "body"
        private const val BINARY_TAG = "binary"

        private const val TITLE_INFO_TAG = "title-info"
        private const val SRC_TITLE_INFO_TAG = "src-title-info"
        private const val DOCUMENT_INFO_TAG = "document-info"
        private const val PUBLISH_INFO_TAG = "publish-info"
        private const val CUSTOM_INFO_TAG = "custom-info"
        private const val OUTPUT_INFO_TAG = "output"

        private const val GENRE_TAG = "genre"
        private const val AUTHOR_TAG = "author"
        private const val BOOK_TITLE_TAG = "book-title"
        private const val ANNOTATION_TAG = "annotation"
        private const val KEYWORDS_TAG = "keywords"
        private const val DATE_TAG = "date"
        private const val COVERPAGE_TAG = "coverpage"
        private const val LANG_TAG = "lang"
        private const val SRC_LANG_TAG = "src-lang"
        private const val TRANSLATOR_TAG = "translator"
        private const val SEQUENCE_TAG = "sequence"

        private const val FIRST_NAME_TAG = "first-name"
        private const val MIDDLE_NAME_TAG = "middle-name"
        private const val LAST_NAME_TAG = "last-name"

        private const val P_TAG = "p"
        private const val STRONG_TAG = "strong"
    }

    // map of (tag, handler)
}

//sealed class Fb2Tag(val name: String)
//
//sealed class FictionBookTag(): Fb2Tag("FictionBook")
//
//sealed class StylesheetTag: FictionBookTag("stylesheet")

fun XmlPullParser.checkStartsWithTag(tag: String) = require(XmlPullParser.START_TAG, null, tag)