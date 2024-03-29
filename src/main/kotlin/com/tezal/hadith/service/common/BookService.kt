package com.tezal.hadith.service.common

import com.tezal.hadith.entity.BookEntity
import com.tezal.hadith.extensions.toDto
import com.tezal.hadith.extensions.toMobileDto
import com.tezal.hadith.model.dto.BookDto
import com.tezal.hadith.model.dto.mobile.BookMobileDto
import com.tezal.hadith.model.dto.mobile.General
import com.tezal.hadith.repo.BookRepo
import com.tezal.hadith.service.base.BaseServiceImpl
import org.springframework.stereotype.Service

@Service
class BookService(val repository: BookRepo) : BaseServiceImpl<BookEntity>(repository) {

    fun findByLang(id: Long): List<BookDto> {
        return repository.findAllByLanguageId(id).map { it.toDto() }
    }

    fun findByLang(code: String): List<BookDto> {
        return repository.findAllByLanguageTitle(code).map { it.toDto() }
    }

    fun findByLangForMobile(code: String): List<BookMobileDto> {
        return repository.findAllByLanguageTitle(code).map { it.toMobileDto() }
    }
}