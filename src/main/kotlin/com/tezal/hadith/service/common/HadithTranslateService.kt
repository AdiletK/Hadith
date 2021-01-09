package com.tezal.hadith.service.common

import com.tezal.hadith.entity.HadithTranslateEntity
import com.tezal.hadith.extensions.toDto
import com.tezal.hadith.model.dto.HadithTranslateDto
import com.tezal.hadith.repo.HadithRepo
import com.tezal.hadith.repo.HadithTranslateRepo
import com.tezal.hadith.repo.LanguageRepo
import com.tezal.hadith.service.base.BaseServiceImpl
import org.springframework.stereotype.Service

@Service
class HadithTranslateService(val repo: HadithTranslateRepo,
                             val hadithRepo: HadithRepo,
                             val languageRepo: LanguageRepo)
    : BaseServiceImpl<HadithTranslateEntity>(repo) {

    fun saveTranslates(listDto: List<HadithTranslateDto>, hadithId: Long) {
        listDto.forEach {
            val entity = HadithTranslateEntity(
                    it.title, it.description,
                    languageRepo.getOne(it.langId),
                    hadithRepo.getOne(hadithId))
            repo.save(entity)
        }
    }

    fun findByHadithId(hadithId: Long): List<HadithTranslateDto> {
        return repo.findAllByHadithId(hadithId).map { it.toDto() }
    }

    fun findByLangId(langId: Long) : List<HadithTranslateEntity> {
        return  repo.findAllByLanguageId(langId)
    }

    fun deleteByHadithId(id: Long) {
        repo.deleteAllByHadithId(id)
    }
}