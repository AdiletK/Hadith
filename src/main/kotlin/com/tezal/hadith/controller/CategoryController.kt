package com.tezal.hadith.controller

import com.tezal.hadith.entity.CategoryEntity
import com.tezal.hadith.service.BaseServiceImpl
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/category")
class CategoryController(service: BaseServiceImpl<CategoryEntity>) : BaseController<CategoryEntity>(service)