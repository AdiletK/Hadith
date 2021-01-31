package com.tezal.hadith.controller.mobile

import com.tezal.hadith.extensions.toMobileDto
import com.tezal.hadith.model.dto.mobile.General
import com.tezal.hadith.model.dto.mobile.HadithMobileApi
import com.tezal.hadith.service.common.BookService
import com.tezal.hadith.service.common.CategoryService
import com.tezal.hadith.service.common.HadithService
import com.tezal.hadith.service.common.SourceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GeneralController(val bookService: BookService,
                        val categoryService: CategoryService,
                        val sourceService: SourceService,
                        val hadithService: HadithService) {

    @GetMapping("/api/book/findAll/{lang}")
    fun findAllBook(@PathVariable lang: String): List<General> {
        return bookService.findByLangForMobile(lang)
    }
    @GetMapping("/api/book/byId/{id}")
    fun findBookById(@PathVariable id: Long): General {
        return bookService.findById(id).toMobileDto()
    }

    @GetMapping("/api/category/findAll/{lang}")
    fun findAllCategory(@PathVariable lang: String): List<General> {
        return categoryService.findByLangForMobile(lang)
    }
    @GetMapping("/api/category/byId/{id}")
    fun findCategoryById(@PathVariable id: Long): General {
        return categoryService.findById(id).toMobileDto()
    }

    @GetMapping("/api/source/findAll/{lang}")
    fun findAllSources(@PathVariable lang: String): List<General> {
        return sourceService.findByLangForMobile(lang)
    }
    @GetMapping("/api/source/byId/{id}")
    fun findSourceById(@PathVariable id: Long): General {
        return sourceService.findById(id).toMobileDto()
    }

    @GetMapping("/api/hadith/findAll/{lang}")
    fun findAllHadith(@PathVariable lang: String): List<HadithMobileApi> {
        return hadithService.findByLang(lang)
    }


}