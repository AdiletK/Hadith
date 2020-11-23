package com.tezal.hadith.controller

import com.tezal.hadith.entity.LoginEntity
import com.tezal.hadith.entity.SettingEntity
import com.tezal.hadith.entity.UserEntity
import com.tezal.hadith.service.BaseServiceImpl
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/login")
class LoginController(service: BaseServiceImpl<LoginEntity>) : BaseController<LoginEntity>(service)