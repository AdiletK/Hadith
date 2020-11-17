package com.tezal.hadith.controller

import com.tezal.hadith.entity.HadithEntity
import com.tezal.hadith.model.HadithModel
import com.tezal.hadith.service.CategoryService
import com.tezal.hadith.service.HadithService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/hadith")
class HadithController(val service: HadithService, val categoryService: CategoryService) {

    @GetMapping("/findAll")
    fun findAll(): List<HadithEntity> {
        return service.findAll()
    }

    @GetMapping("/findByCatId/{id}")
    fun findAllByCatId(@PathVariable id: Long): List<HadithEntity> {
        return service.findAllByCatId(id)
    }

    @GetMapping("/findById/{id}")
    fun findById(@PathVariable id: Long): HadithEntity {
        return service.findById(id)
    }

    @PostMapping("/save")
    fun save(@RequestBody model: HadithModel): HadithEntity {
        val newItem = HadithEntity(model.title, model.description, categoryService.findById(model.categoryId))
        newItem.status = model.status
        return service.create(newItem)
    }

    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody model: HadithModel): HadithEntity {
        return service.update(convert(id, model))
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