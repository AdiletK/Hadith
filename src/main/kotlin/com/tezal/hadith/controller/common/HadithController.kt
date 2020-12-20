package com.tezal.hadith.controller.common

import com.tezal.hadith.entity.HadithEntity
import com.tezal.hadith.extensions.toDto
import com.tezal.hadith.model.HadithModel
import com.tezal.hadith.model.dto.HadithDto
import com.tezal.hadith.service.common.BookService
import com.tezal.hadith.service.common.CategoryService
import com.tezal.hadith.service.common.HadithService
import com.tezal.hadith.service.common.SourceService
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/hadith")
class HadithController(val service: HadithService, val categoryService: CategoryService,
                       val bookService: BookService, val sourceService: SourceService) {

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

    @Secured("ROLE_ADMIN")
    @PostMapping("/save")
    fun save(@RequestBody model: HadithModel): HadithDto {
        val newItem = HadithEntity(model.title, model.description,
                categoryService.findById(model.categoryId),
                bookService.findById(model.bookId),
                model.sourcesId?.map { sourceService.findById(it) })
        newItem.status = model.status
        return service.create(newItem).toDto()
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody model: HadithModel): HadithDto {
        return service.update(convert(id, model)).toDto()
    }
    @Secured("ROLE_ADMIN")
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long){
        service.deleteById(id)
    }

    private fun convert(id: Long, model: HadithModel): HadithEntity {
        val item = service.findById(id)
        item.category = categoryService.findById(model.categoryId)
        item.book = bookService.findById(model.bookId)
        item.sources = model.sourcesId?.map { sourceService.findById(it) }
        item.description = model.description
        item.title = model.title
        item.status = model.status
        return item
    }
}