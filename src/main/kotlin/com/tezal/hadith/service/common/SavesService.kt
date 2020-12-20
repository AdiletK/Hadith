package com.tezal.hadith.service.common

import com.tezal.hadith.entity.SavesEntity
import com.tezal.hadith.model.SavesModel
import com.tezal.hadith.repo.SavesRepo
import com.tezal.hadith.service.base.BaseServiceImpl
import org.springframework.stereotype.Service

@Service
class SavesService(val repository: SavesRepo,
                   val hadithService: HadithService, val userService: UserService)
    : BaseServiceImpl<SavesEntity>(repository) {

    fun findByUserId(id: Long): List<SavesEntity> {
        return repository.findAllByUser_Id(id)
    }

    fun findByHadithId(id: Long): List<SavesEntity> {
        return repository.findAllByHadyth_Id(id)
    }

    fun convert(model: SavesModel): SavesEntity {
        val newItem = SavesEntity(hadithService.findById(model.hadithId),
                userService.findById(model.userId))
        newItem.status = model.status
        return newItem
    }

}