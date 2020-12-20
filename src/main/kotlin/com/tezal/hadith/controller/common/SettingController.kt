package com.tezal.hadith.controller.common

import com.tezal.hadith.controller.base.BaseController
import com.tezal.hadith.entity.SettingEntity
import com.tezal.hadith.service.base.BaseServiceImpl
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/setting")
class SettingController(service: BaseServiceImpl<SettingEntity>) : BaseController<SettingEntity>(service)