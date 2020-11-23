package com.tezal.hadith.model

import com.tezal.hadith.enum.StatusList

data class HadithModel(
        val categoryId: Long,
        val description: String,
        val title: String,
        val status: StatusList,
        val books: Set<Long>
)