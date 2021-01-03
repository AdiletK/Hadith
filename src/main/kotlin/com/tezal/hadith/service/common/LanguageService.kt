package com.tezal.hadith.service.common

import com.tezal.hadith.entity.LanguageEntity
import com.tezal.hadith.repo.LanguageRepo
import com.tezal.hadith.service.base.BaseServiceImpl
import org.springframework.stereotype.Service

@Service
class LanguageService(repository: LanguageRepo) : BaseServiceImpl<LanguageEntity>(repository) {
}