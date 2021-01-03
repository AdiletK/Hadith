package com.tezal.hadith.repo

import com.tezal.hadith.entity.HadithEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HadithRepo : JpaRepository<HadithEntity, Long>{
    fun findAllByCategoryId(id: Long):List<HadithEntity>
    
    fun findAllByLanguageId(id: Long): List<HadithEntity>
    
    fun findAllByLanguageTitle(code: String): List<HadithEntity>
}