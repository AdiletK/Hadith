package com.tezal.hadith.service

import com.tezal.hadith.entity.HadithEntity
import com.tezal.hadith.repo.HadithRepo
import org.springframework.stereotype.Service

@Service
class HadithService(val repository: HadithRepo) : BaseServiceImpl<HadithEntity>(repository){
    fun findAllByCatId(id: Long) : List<HadithEntity>{
        return repository.findAllByCategory_Id(id)
    }
}