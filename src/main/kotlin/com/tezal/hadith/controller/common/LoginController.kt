package com.tezal.hadith.controller.common

import com.tezal.hadith.controller.base.BaseController
import com.tezal.hadith.entity.LoginEntity
import com.tezal.hadith.service.base.BaseServiceImpl
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/login")
class LoginController(service: BaseServiceImpl<LoginEntity>) : BaseController<LoginEntity>(service)