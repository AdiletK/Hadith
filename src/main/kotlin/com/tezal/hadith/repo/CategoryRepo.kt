package com.tezal.hadith.repo

import com.tezal.hadith.entity.CategoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepo : JpaRepository<CategoryEntity, Long>