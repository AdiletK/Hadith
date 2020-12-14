package com.tezal.hadith.controller

import com.tezal.hadith.entity.SavesEntity
import com.tezal.hadith.extensions.toDto
import com.tezal.hadith.model.SavesModel
import com.tezal.hadith.model.dto.SavesDto
import com.tezal.hadith.service.HadithService
import com.tezal.hadith.service.SavesService
import com.tezal.hadith.service.UserService
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/saves")
class SavesController(val service: SavesService,
                      val hadithService: HadithService, val userService: UserService) {
    @GetMapping("/findAll")
    fun findAll(): List<SavesDto> {
        return service.findAll().map {
            it.toDto()
        }
    }

    @GetMapping("/findByUserId/{id}")
    fun findUserId(@PathVariable id: Long): List<SavesDto> {
        return service.findByUserId(id).map {
            it.toDto()
        }
    }

    @GetMapping("/findByHadithId/{id}")
    fun findHadithId(@PathVariable id: Long): List<SavesDto> {
        return service.findByHadithId(id).map {
            it.toDto()
        }
    }

    @GetMapping("/findById/{id}")
    fun findById(@PathVariable id: Long): SavesDto {
        return service.findById(id).toDto()
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/save")
    fun save(@RequestBody model: SavesModel): SavesDto {
        val newItem = SavesEntity(hadithService.findById(model.hadithId), userService.findById(model.userId))
        newItem.status = model.status
        return service.create(newItem).toDto()
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody model: SavesModel): SavesDto {
        val item = service.findById(id)
        item.hadyth = hadithService.findById(model.hadithId)
        item.user = userService.findById(model.userId)
        item.status = model.status
        return service.update(item).toDto()
    }
}