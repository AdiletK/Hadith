package com.tezal.hadith.repo

import com.tezal.hadith.entity.HadithTranslateEntity
import org.springframework.data.jpa.repository.JpaRepository

interface HadithTranslateRepo: JpaRepository<HadithTranslateEntity, Long> {
    fun findAllByHadithId(id: Long): List<HadithTranslateEntity>

    fun findAllByLanguageId(id: Long) : List<HadithTranslateEntity>
}