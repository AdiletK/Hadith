package com.tezal.hadith.model.dto

import com.tezal.hadith.enums.StatusList

data class HadithTranslateDto(
        var id: Long?,
        var hadithId: Long?,
        val title: String,
        val description: String,
        val langId: Long,
        val langTitle: String?,
        val status: StatusList
)