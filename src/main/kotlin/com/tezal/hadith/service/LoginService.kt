package com.tezal.hadith.service

import com.tezal.hadith.entity.LoginEntity
import com.tezal.hadith.repo.LoginRepo
import org.springframework.stereotype.Service

@Service
class LoginService(val repository: LoginRepo) : BaseServiceImpl<LoginEntity>(repository) {

}