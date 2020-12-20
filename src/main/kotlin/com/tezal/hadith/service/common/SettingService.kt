package com.tezal.hadith.service.common

import com.tezal.hadith.entity.SettingEntity
import com.tezal.hadith.repo.SettingRepo
import com.tezal.hadith.service.base.BaseServiceImpl
import org.springframework.stereotype.Service

@Service
class SettingService(val repository: SettingRepo) : BaseServiceImpl<SettingEntity>(repository) {

}