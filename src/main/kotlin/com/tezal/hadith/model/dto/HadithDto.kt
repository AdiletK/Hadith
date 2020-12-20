package com.tezal.hadith.model.dto

data class HadithDto(
        val id: Long,
        val title: String,
        val description: String,
        val status: String,
        val categoryId: Long,
        val categoryName: String,
        val bookId: Long,
        val bookTitle: String,
        val sources: List<SourceDto>?
        )