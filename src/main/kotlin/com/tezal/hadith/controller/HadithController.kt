package com.tezal.hadith.controller

import com.tezal.hadith.entity.HadithEntity
import com.tezal.hadith.extensions.toDto
import com.tezal.hadith.model.HadithModel
import com.tezal.hadith.model.dto.HadithDto
import com.tezal.hadith.service.CategoryService
import com.tezal.hadith.service.HadithService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/hadith")
class HadithController(val service: HadithService, val categoryService: CategoryService) {

    @GetMapping("/findAll")
    fun findAll(): List<HadithDto> {
        return service.findAll().map {
            it.toDto()
        }
    }

    @GetMapping("/findByCatId/{id}")
    fun findAllByCatId(@PathVariable id: Long): List<HadithDto> {
        return service.findAllByCatId(id).map {
            it.toDto()
        }
    }

    @GetMapping("/findById/{id}")
    fun findById(@PathVariable id: Long): HadithDto {
        return service.findById(id).toDto()
    }

    @PostMapping("/save")
    fun save(@RequestBody model: HadithModel): HadithDto {
        val newItem = HadithEntity(model.title, model.description, categoryService.findById(model.categoryId))
        newItem.status = model.status
        return service.create(newItem).toDto()
    }

    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody model: HadithModel): HadithDto {
        return service.update(convert(id, model)).toDto()
    }

    private fun convert(id: Long, model: HadithModel): HadithEntity {
        val item = service.findById(id)
        item.category = categoryService.findById(model.categoryId)
        item.description = model.description
        item.title = model.title
        item.status = model.status
        return item
    }
}