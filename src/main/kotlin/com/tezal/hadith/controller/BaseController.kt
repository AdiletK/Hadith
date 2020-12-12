package com.tezal.hadith.controller

import com.tezal.hadith.entity.BaseEntity
import com.tezal.hadith.service.BaseService
import org.springframework.web.bind.annotation.*


abstract class BaseController<ENTITY : BaseEntity>(private var service: BaseService<ENTITY>) {

    @GetMapping("/findAll")
    fun findAll(): List<ENTITY> {
        return service.findAll()
    }

    @GetMapping("/findById/{id}")
    fun findById(@PathVariable id: Long): ENTITY {
        return service.findById(id)
    }

    @PostMapping("/save")
    fun save(@RequestBody entity: ENTITY): ENTITY {
        return service.create(entity)
    }

    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody entity: ENTITY): ENTITY {
        entity.id = id
        return service.update(entity)
    }
    @DeleteMapping("delete/{id}")
    fun delete(@PathVariable id: Long){
        service.deleteById(id)
    }

}