package com.tezal.hadith.service.common

import com.tezal.hadith.entity.CategoryEntity
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
                    null,
                    it.position)
            if (it.sourceId != null)
                entity.source = sourceRepo.getOne(it.sourceId)

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
        return repo.findAllByLanguageTitleOrderByPositionAsc(title.toLowerCase())
    }

    fun findByLangTitleAndCategoryId(title: String, categoryId: Long): List<HadithTranslateEntity> {
        val hadith: List<HadithTranslateEntity> =
                repo.findAllByLanguageTitleOrderByPositionAsc(title.toLowerCase())
        val category: CategoryEntity = categoryRepo.findById(categoryId)
                .orElseThrow { RuntimeException("Category not found!!!") }
        return hadith.filter {
            it.categories.contains(category)
        }
    }

    @Transactional
    fun deleteByHadithId(id: Long) {
        repo.deleteAllByHadithId(id)
    }
}