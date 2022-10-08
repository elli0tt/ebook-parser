package com.elli0tt.ebook_parser.fb2.tags

import com.elli0tt.ebook_parser.fb2.RequiredParamNotProvidedException

class Description private constructor(
    val titleInfo: TitleInfo,
    val srcTitleInfo: SrcTitleInfo?,
    val documentInfo: DocumentInfo,
    val publishInfo: PublishInfo?,
    val customInfoList: List<CustomInfo>?,
    val outputs: List<Output>?
) {

    class Builder {
        private var titleInfo: TitleInfo? = null
        private var srcTitleInfo: SrcTitleInfo? = null
        private var documentInfo: DocumentInfo? = null
        private var publishInfo: PublishInfo? = null
        private var customInfoList = arrayListOf<CustomInfo>()
        private var outputs = arrayListOf<Output>()

        fun setTitleInfo(titleInfo: TitleInfo): Builder = apply { this.titleInfo = titleInfo }

        fun setSrcTitleInfo(srcTitleInfo: SrcTitleInfo): Builder = apply {
            this.srcTitleInfo = srcTitleInfo
        }

        fun setDocumentInfo(documentInfo: DocumentInfo): Builder = apply {
            this.documentInfo = documentInfo
        }

        fun setPublishInfo(publishInfo: PublishInfo): Builder = apply {
            this.publishInfo = publishInfo
        }

        fun addCustomInfo(customInfo: CustomInfo): Builder = apply { customInfoList += customInfo }

        fun addOutput(output: Output): Builder = apply { outputs += output }

        fun build(): Description {
            return Description(
                titleInfo ?: throw RequiredParamNotProvidedException("titleInfo"),
                srcTitleInfo,
                documentInfo ?: throw RequiredParamNotProvidedException("documentInfo"),
                publishInfo,
                customInfoList,
                outputs
            )
        }
    }
}