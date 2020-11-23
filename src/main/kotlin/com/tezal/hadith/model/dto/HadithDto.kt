package com.tezal.hadith.model.dto

import java.time.LocalDateTime

data class HadithDto(
        val id: Long,
        val title: String,
        val description: String,
        val createDate: LocalDateTime,
        val updateDate: LocalDateTime,
        val status: String,
        val categoryId: Long,
        val categoryName: String,
        val books: Set<BookDto>
)