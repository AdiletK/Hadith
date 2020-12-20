package com.tezal.hadith.service.auth

import com.tezal.hadith.entity.LoginEntity
import com.tezal.hadith.repo.LoginRepo
import com.tezal.hadith.service.base.BaseServiceImpl
import org.springframework.stereotype.Service

@Service
class LoginService(val repository: LoginRepo) : BaseServiceImpl<LoginEntity>(repository) {

}