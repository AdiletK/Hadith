package com.tezal.hadith.model

import com.tezal.hadith.enums.StatusList
import com.tezal.hadith.model.dto.HadithTranslateDto

data class HadithWithTranslateModel(
        val status: StatusList,
        val transcript: String?,
        val imageUrl: String?,
        val translateDto: List<HadithTranslateDto>?
)