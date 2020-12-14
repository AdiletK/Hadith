package com.tezal.hadith.controller

import com.tezal.hadith.entity.BaseEntity
import com.tezal.hadith.service.BaseService
import org.springframework.security.access.annotation.Secured
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import javax.persistence.MappedSuperclass


@MappedSuperclass
abstract class BaseController<ENTITY : BaseEntity>(private var service: BaseService<ENTITY>) {

    @GetMapping("/findAll")
    open fun findAll(): List<ENTITY> {
        return service.findAll()
    }

    @Secured("ROLE_ANONYMOUS")
    @GetMapping("/findById/{id}")
    fun findById(@PathVariable id: Long): ENTITY {
        return service.findById(id)
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/save")
    fun save(@RequestBody entity: ENTITY): ENTITY {
        return service.create(entity)
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody entity: ENTITY): ENTITY {
        entity.id = id
        return service.update(entity)
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("delete/{id}")
    fun delete(@PathVariable id: Long){
        service.deleteById(id)
    }

}