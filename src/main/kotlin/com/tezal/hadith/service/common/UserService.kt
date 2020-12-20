package com.tezal.hadith.service.common

import com.tezal.hadith.entity.UserEntity
import com.tezal.hadith.service.base.BaseServiceImpl
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class UserService (repository: JpaRepository<UserEntity, Long>) : BaseServiceImpl<UserEntity>(repository)