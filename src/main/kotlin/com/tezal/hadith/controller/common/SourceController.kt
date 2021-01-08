package com.tezal.hadith.controller.common

import com.tezal.hadith.entity.SourceEntity
import com.tezal.hadith.extensions.toDto
import com.tezal.hadith.model.dto.SourceDto
import com.tezal.hadith.service.common.LanguageService
import com.tezal.hadith.service.common.SourceService
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/source")
class SourceController(val service: SourceService,
                       val languageService: LanguageService) {

    @GetMapping("/findAll")
    fun findAll(): List<SourceDto> {
        return service.findAll().map { it.toDto() }
    }

    @GetMapping("/findById/{id}")
    fun findById(@PathVariable id: Long): SourceDto {
        return service.findById(id).toDto()
    }

    @GetMapping("/findByLangId/{id}")
    fun findByLangId(@PathVariable id: Long): List<SourceDto> {
        return service.findByLangId(id)
    }

    @GetMapping("/findByLangCode/{code}")
    fun findByLangCode(@PathVariable code: String): List<SourceDto> {
        return service.findByLangCode(code)
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/save")
    fun save(@RequestBody dto: SourceDto): SourceDto {
        return service.create(SourceEntity(dto.title, language = languageService.findById(dto.langId!!), hadiths = Collections.emptyList())).toDto()
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: SourceDto): SourceDto {
        val entity = SourceEntity(dto.title, language = languageService.findById(dto.langId!!), hadiths = Collections.emptyList())
        entity.id = id
        return service.update(entity).toDto()
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long) {
        service.deleteById(id)
    }
}