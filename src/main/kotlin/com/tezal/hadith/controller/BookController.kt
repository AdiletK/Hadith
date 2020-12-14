package com.tezal.hadith.controller

import com.tezal.hadith.entity.BookEntity
import com.tezal.hadith.enums.StatusList
import com.tezal.hadith.extensions.toDto
import com.tezal.hadith.model.dto.BookDto
import com.tezal.hadith.service.BookService
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/book")
class BookController(val service: BookService) {

    @GetMapping("/findAll")
    fun findAll(): List<BookDto> {
        return service.findAll().map {
            it.toDto()
        }
    }

    @GetMapping("/findById/{id}")
    fun findById(@PathVariable id: Long): BookDto {
        return service.findById(id).toDto()
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/save")
    fun save(@RequestBody model: BookDto): BookDto {
        val newItem = BookEntity(model.title, model.description, model.author)
        newItem.status = StatusList.ENABLED
        return service.create(newItem).toDto()
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody model: BookDto): BookDto {
        val newItem = BookEntity(model.title, model.description, model.author)
        newItem.id = id
        return service.update(newItem).toDto()
    }
    @Secured("ROLE_ADMIN")
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long){
        service.deleteById(id)
    }

}