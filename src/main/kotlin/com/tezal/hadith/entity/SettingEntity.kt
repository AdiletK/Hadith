package com.tezal.hadith.entity

import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "setting_table")
data class SettingEntity(
        val isNotifEnabled: Boolean,
        val countOfNotif: Int,
        @ManyToOne val lastSentHadith: HadithEntity
) : BaseEntity()