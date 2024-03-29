package com.tezal.hadith.repo

import com.tezal.hadith.entity.SavesEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SavesRepo : JpaRepository<SavesEntity, Long> {
    fun findAllByUser_Id(id: Long): List<SavesEntity>

    fun findAllByHadyth_Id(id: Long): List<SavesEntity>
}