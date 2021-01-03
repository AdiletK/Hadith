package com.tezal.hadith.model.dto

data class SourceDto(
        val id: Long,
        val title: String,
        val langId: Long?,
        val langTitle: String?
)