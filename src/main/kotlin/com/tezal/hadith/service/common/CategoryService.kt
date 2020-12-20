package com.tezal.hadith.service.common

import com.tezal.hadith.entity.CategoryEntity
import com.tezal.hadith.service.base.BaseServiceImpl
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(repository: JpaRepository<CategoryEntity, Long>) : BaseServiceImpl<CategoryEntity>(repository) {
}