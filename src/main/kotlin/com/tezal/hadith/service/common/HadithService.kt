package com.tezal.hadith.service.common

import com.tezal.hadith.entity.HadithEntity
import com.tezal.hadith.extensions.toDto
import com.tezal.hadith.model.dto.HadithDto
import com.tezal.hadith.repo.HadithRepo
import com.tezal.hadith.service.base.BaseServiceImpl
import org.springframework.stereotype.Service

@Service
class HadithService(val repository: HadithRepo) : BaseServiceImpl<HadithEntity>(repository){
    fun findAllByCatId(id: Long) : List<HadithEntity>{
        return repository.findAllByCategoryId(id)
    }

//    fun findByLang(id: Long): List<HadithDto> {
//        return repository.findAllByLanguageId(id).map { it.toDto() }
//    }
//    fun findByLang(code: String): List<HadithDto> {
//        return repository.findAllByLanguageTitle(code).map { it.toDto() }
//    }
}