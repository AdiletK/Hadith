package com.tezal.hadith.model

import com.tezal.hadith.enums.StatusList

data class HadithModel(
        val categoryId: Long,
        val description: String,
        val title: String,
        val status: StatusList,
        val book: Long
)