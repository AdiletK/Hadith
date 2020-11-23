package com.tezal.hadith.repo

import com.tezal.hadith.entity.LoginEntity
import org.springframework.data.jpa.repository.JpaRepository

interface LoginRepo: JpaRepository<LoginEntity, Long> {
}