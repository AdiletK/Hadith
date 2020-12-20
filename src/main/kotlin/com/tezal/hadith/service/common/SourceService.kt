package com.tezal.hadith.service.common

import com.tezal.hadith.entity.SourceEntity
import com.tezal.hadith.repo.SourceRepo
import com.tezal.hadith.service.base.BaseServiceImpl
import org.springframework.stereotype.Service

@Service
class SourceService(repository: SourceRepo) : BaseServiceImpl<SourceEntity>(repository) {
}