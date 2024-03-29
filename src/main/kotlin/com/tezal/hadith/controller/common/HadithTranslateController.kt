package com.tezal.hadith.controller.common

import com.tezal.hadith.entity.HadithTranslateEntity
import com.tezal.hadith.extensions.toDto
import com.tezal.hadith.model.dto.HadithTranslateDto
import com.tezal.hadith.model.dto.HadithWithTranslate
import com.tezal.hadith.service.common.*
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*
import java.util.*
import kotlin.collections.ArrayList

@RestController
@RequestMapping("/api/hadith_translte/")
class HadithTranslateController(val service: HadithTranslateService,
                                val languageService: LanguageService,
                                val hadithService: HadithService,
                                val sourceService: SourceService,
                                val categoryService: CategoryService) {
    @GetMapping("findAll")
    fun findAll(): List<HadithTranslateDto> {
        return service.findAll().map { it.toDto() }
    }

    @GetMapping("findById/{id}")
    fun getById(@PathVariable id: Long): HadithTranslateDto {
        return service.findById(id).toDto()
    }

    @GetMapping("findByLangId/{id}")
    fun getByLangId(@PathVariable id: Long): List<HadithWithTranslate> {
        val res: ArrayList<HadithWithTranslate> = ArrayList()
        val list = service.findByLangId(id).map { it.toDto() }
        list.forEach {
            res.add(HadithWithTranslate(hadithService.findById(it.hadithId!!).toDto(),
                    Collections.singletonList(it)))
        }
        return res

    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/save")
    fun save(@RequestBody dto: HadithTranslateDto): HadithTranslateDto {
        val entity = HadithTranslateEntity(
                dto.title, dto.description,
                languageService.findById(dto.langId), hadithService.findById(dto.hadithId!!),
                sourceService.findById(dto.sourceId!!), dto.position)
        entity.categories = listOf(categoryService.findById(dto.categoryId!!))
        return service.create(entity).toDto()
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: HadithTranslateDto): HadithTranslateDto {
        val updateEntity = service.findById(id)
        updateEntity.title = dto.title
        updateEntity.status = dto.status
        updateEntity.description = dto.description
        updateEntity.language = languageService.findById(dto.langId)
        updateEntity.hadith = hadithService.findById(dto.hadithId!!)
        updateEntity.position = dto.position
        updateEntity.source = sourceService.findById(dto.sourceId!!)
        updateEntity.categories = listOf(categoryService.findById(dto.categoryId!!))
        return service.create(updateEntity).toDto()
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long) {
        service.deleteById(id)
    }
}