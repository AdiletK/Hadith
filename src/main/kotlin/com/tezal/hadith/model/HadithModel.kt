package com.tezal.hadith.model

import com.tezal.hadith.enums.StatusList
import com.tezal.hadith.model.dto.HadithTranslateDto

data class HadithModel(
        val categoriesId: List<Long>,
        val status: StatusList,
        val bookId: Long,
        val sourcesId: List<Long>?,
        val transcript: String?,
        val imageUrl: String?,
)