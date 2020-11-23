package com.tezal.hadith.controller

import com.tezal.hadith.entity.BookEntity
import com.tezal.hadith.enum.StatusList
import com.tezal.hadith.extensions.toDto
import com.tezal.hadith.model.dto.BookDto
import com.tezal.hadith.service.BookService
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

    @PostMapping("/save")
    fun save(@RequestBody model: BookDto): BookDto {
        val newItem = BookEntity(model.title, model.description, model.author, emptySet())
        newItem.status = StatusList.ENABLED
        return service.create(newItem).toDto()
    }

    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody model: BookDto): BookDto {
        val newItem = BookEntity(model.title, model.description, model.author, emptySet())
        newItem.id = id
        return service.update(newItem).toDto()
    }

}