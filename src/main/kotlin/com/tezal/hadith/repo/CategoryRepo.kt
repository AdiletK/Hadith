package com.tezal.hadith.repo

import com.tezal.hadith.entity.CategoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepo : JpaRepository<CategoryEntity, Long> {
    fun findAllByLanguageId(id: Long): List<CategoryEntity>
    fun findAllByLanguageTitleOrderByPositionAsc(code: String): List<CategoryEntity>

    fun findAllByLanguageTitleAndBookIdOrderByPositionAsc(code: String, bookId: Long) : List<CategoryEntity>
}