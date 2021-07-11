package com.tezal.hadith.service.common

import com.tezal.hadith.entity.CategoryEntity
import com.tezal.hadith.extensions.toDto
import com.tezal.hadith.extensions.toMobileDto
import com.tezal.hadith.model.dto.CategoryDto
import com.tezal.hadith.model.dto.mobile.CategoryMobileDto
import com.tezal.hadith.model.dto.mobile.General
import com.tezal.hadith.repo.CategoryRepo
import com.tezal.hadith.service.base.BaseServiceImpl
import org.springframework.stereotype.Service

@Service
class CategoryService(val repository: CategoryRepo) : BaseServiceImpl<CategoryEntity>(repository) {
    fun findByLang(id: Long): List<CategoryDto> {
        return repository.findAllByLanguageId(id).map { it.toDto() }
    }

    fun findByLang(code: String): List<CategoryDto> {
        return repository.findAllByLanguageTitle(code).map { it.toDto() }
    }

    fun findByLangForMobile(code: String): List<CategoryMobileDto> {
        return repository.findAllByLanguageTitle(code).map { it.toMobileDto() }
    }

    fun findByLangAndByBookId(code: String, bookId: Long): List<CategoryMobileDto> {
        return repository.findAllByLanguageTitleAndBookIdOrderByPositionAsc(code, bookId)
                .map { it.toMobileDto() };
    }
}