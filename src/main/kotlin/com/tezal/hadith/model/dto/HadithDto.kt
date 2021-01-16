package com.tezal.hadith.model.dto

data class HadithDto(
        val id: Long,
        val status: String,
        val categories: List<CategoryDto>,
        val bookId: Long,
        val bookTitle: String,
        val sources: List<SourceDto>?,
        )