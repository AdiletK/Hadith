package com.tezal.hadith.service

import com.tezal.hadith.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class UserService (repository: JpaRepository<UserEntity, Long>) : BaseServiceImpl<UserEntity>(repository)