package com.tezal.hadith.service.common

import com.tezal.hadith.entity.HadithEntity
import com.tezal.hadith.model.dto.mobile.HadithMobileApi
import com.tezal.hadith.repo.HadithRepo
import com.tezal.hadith.service.base.BaseServiceImpl
import org.springframework.stereotype.Service

@Service
class HadithService(val repository: HadithRepo,
                    val translateService: HadithTranslateService) : BaseServiceImpl<HadithEntity>(repository) {
//    fun findAllByCatId(id: Long) : List<HadithEntity>{
//        return repository.findAllByCategoryId(id)
//    }

    //    fun findByLang(id: Long): List<HadithDto> {
//        return repository.findAllByLanguageId(id).map { it.toDto() }
//    }
    fun findByLang(code: String): List<HadithMobileApi> {
        val res: ArrayList<HadithMobileApi> = ArrayList()
        val translates = translateService.findByLangTitle(code)
        translates.forEach {
            val hadith = repository.findById(it.hadith.id!!).get()
            res.add(HadithMobileApi(
                    hadith.id!!, it.categories.map { it.id!! },
                    it.source?.id, it.title,
                    it.description, hadith.imageUrl, it.position
            ))
        }
        return res;
    }

    fun findByLang(code: String, categoryId: Long): List<HadithMobileApi> {
        val res: ArrayList<HadithMobileApi> = ArrayList()
        val translates = translateService.findByLangTitleAndCategoryId(code, categoryId)
        translates.forEach {
            val hadith = repository.findById(it.hadith.id!!).get()
            res.add(HadithMobileApi(
                    hadith.id!!, it.categories.map { it.id!! },
                    it.source?.id, it.title,
                    it.description, hadith.imageUrl, it.position
            ))
        }
        return res;
    }

}