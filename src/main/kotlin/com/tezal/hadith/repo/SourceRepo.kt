package com.tezal.hadith.repo

import com.tezal.hadith.entity.SourceEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SourceRepo : JpaRepository<SourceEntity, Long>