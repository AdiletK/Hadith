package com.tezal.hadith.repo

import com.tezal.hadith.entity.SettingEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SettingRepo : JpaRepository<SettingEntity, Long>