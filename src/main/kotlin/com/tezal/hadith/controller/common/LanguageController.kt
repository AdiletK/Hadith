package com.tezal.hadith.controller.common

import com.tezal.hadith.controller.base.BaseController
import com.tezal.hadith.entity.CategoryEntity
import com.tezal.hadith.entity.LanguageEntity
import com.tezal.hadith.service.base.BaseServiceImpl
import com.tezal.hadith.service.common.LanguageService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/language")
class LanguageController(service: LanguageService) : BaseController<LanguageEntity>(service)