package com.tezal.hadith.service.common

import com.tezal.hadith.entity.HadithTranslateEntity
import com.tezal.hadith.extensions.toDto
import com.tezal.hadith.model.dto.HadithTranslateDto
import com.tezal.hadith.repo.*
import com.tezal.hadith.service.base.BaseServiceImpl
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class HadithTranslateService(val repo: HadithTranslateRepo,
                             val hadithRepo: HadithRepo,
                             val languageRepo: LanguageRepo,
                             val bookRepo: BookRepo,
                             val sourceRepo: SourceRepo,
                             val categoryRepo: CategoryRepo)
    : BaseServiceImpl<HadithTranslateEntity>(repo) {

    @Transactional
    fun saveTranslates(listDto: List<HadithTranslateDto>, hadithId: Long) {
        listDto.forEach { it ->
            val entity = HadithTranslateEntity(
                    it.title, it.description,
                    languageRepo.getOne(it.langId),
                    hadithRepo.getOne(hadithId),
                    bookRepo.getOne(it.bookId),
                    sourceRepo.getOne(it.sourceId)
            )
            entity.categories = it.categories.map { categoryRepo.getOne(it) }
            if (it.id != null)
                entity.id = it.id
            repo.save(entity)

        }
    }

    fun findByHadithId(hadithId: Long): List<HadithTranslateDto> {
        return repo.findAllByHadithId(hadithId).map { it.toDto() }
    }

    fun findByLangId(langId: Long): List<HadithTranslateEntity> {
        return repo.findAllByLanguageId(langId)
    }

    fun findByLangTitle(title: String): List<HadithTranslateEntity> {
        return repo.findAllByLanguageTitle(title.toLowerCase())
    }

    @Transactional
    fun deleteByHadithId(id: Long) {
        repo.deleteAllByHadithId(id)
    }
}