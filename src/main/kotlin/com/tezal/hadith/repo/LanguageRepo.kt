package com.tezal.hadith.repo

import com.tezal.hadith.entity.LanguageEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LanguageRepo : JpaRepository<LanguageEntity, Long>