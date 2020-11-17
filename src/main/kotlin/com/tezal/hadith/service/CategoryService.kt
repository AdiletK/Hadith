package com.tezal.hadith.service

import com.tezal.hadith.entity.CategoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(repository: JpaRepository<CategoryEntity, Long>) : BaseServiceImpl<CategoryEntity>(repository) {
}