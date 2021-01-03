package com.tezal.hadith.service.common

import com.tezal.hadith.entity.SourceEntity
import com.tezal.hadith.extensions.toDto
import com.tezal.hadith.model.dto.SourceDto
import com.tezal.hadith.repo.SourceRepo
import com.tezal.hadith.service.base.BaseServiceImpl
import org.springframework.stereotype.Service

@Service
class SourceService(val repository: SourceRepo) : BaseServiceImpl<SourceEntity>(repository) {
    fun findByLangId(id: Long): List<SourceDto> {
        return repository.findAllByLanguageId(id).map { it.toDto() }
    }

    fun findByLangCode(code: String): List<SourceDto> {
        return repository.findAllByLanguageTitle(code).map { it.toDto() }
    }
}