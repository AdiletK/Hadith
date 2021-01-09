package com.tezal.hadith.controller.common

import com.tezal.hadith.entity.CategoryEntity
import com.tezal.hadith.enums.StatusList
import com.tezal.hadith.extensions.toDto
import com.tezal.hadith.model.dto.CategoryDto
import com.tezal.hadith.service.common.CategoryService
import com.tezal.hadith.service.common.LanguageService
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/category")
class CategoryController(val service: CategoryService, val languageService: LanguageService) {
    @GetMapping("/findAll")
    fun findAll(): List<CategoryDto> {
        return service.findAll().map {
            it.toDto()
        }
    }

    @GetMapping("/findById/{id}")
    fun findById(@PathVariable id: Long): CategoryDto {
        return service.findById(id).toDto()
    }
    @GetMapping("/findByLangId/{id}")
    fun findByLang(@PathVariable id: Long): List<CategoryDto>{
        return service.findByLang(id)
    }
    @GetMapping("/findByLangCode/{code}")
    fun findByLangCode(@PathVariable code: String): List<CategoryDto>{
        return service.findByLang(code)
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/save")
    fun save(@RequestBody model: CategoryDto): CategoryDto {
        val newItem = CategoryEntity(model.title, languageService.findById(model.langId!!))
        return service.create(newItem).toDto()
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody model: CategoryDto): CategoryDto {
        val newItem = CategoryEntity(model.title, languageService.findById(model.langId!!))
        newItem.id = id
        newItem.status = model.status!!
        return service.update(newItem).toDto()
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long) {
        service.deleteById(id)
    }
}