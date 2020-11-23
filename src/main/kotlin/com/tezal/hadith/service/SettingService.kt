package com.tezal.hadith.service

import com.tezal.hadith.entity.SettingEntity
import com.tezal.hadith.repo.SettingRepo
import org.springframework.stereotype.Service

@Service
class SettingService(val repository: SettingRepo) : BaseServiceImpl<SettingEntity>(repository) {

}