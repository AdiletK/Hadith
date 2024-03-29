package com.tezal.hadith.model.dto

import com.tezal.hadith.enums.StatusList

data class HadithTranslateDto(
        var id: Long?,
        var hadithId: Long?,
        val title: String,
        val description: String,
        val langId: Long,
        val langTitle: String?,
        val status: StatusList,
        val sourceId: Long?,
        val sourceTitle: String?,
        val categoryId: Long?,
        val position: Int,
        val bookId:Long
)