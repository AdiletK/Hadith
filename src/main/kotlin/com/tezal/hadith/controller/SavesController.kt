package com.tezal.hadith.controller

import com.tezal.hadith.entity.SavesEntity
import com.tezal.hadith.model.SavesModel
import com.tezal.hadith.service.HadithService
import com.tezal.hadith.service.SavesService
import com.tezal.hadith.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/saves")
class SavesController(val service: SavesService,
                      val hadithService: HadithService, val userService: UserService) {
    @GetMapping("/findAll")
    fun findAll(): List<SavesEntity> {
        return service.findAll()
    }

    @GetMapping("/findUserId/{id}")
    fun findUserId(@PathVariable id: Long): List<SavesEntity> {
        return service.findByUserId(id)
    }

    @GetMapping("/findHadithId/{id}")
    fun findHadithId(@PathVariable id: Long): List<SavesEntity> {
        return service.findByHadithId(id)
    }

    @GetMapping("/findById/{id}")
    fun findById(@PathVariable id: Long): SavesEntity {
        return service.findById(id)
    }

    @PostMapping("/save")
    fun save(@RequestBody model: SavesModel): SavesEntity {
        val newItem = SavesEntity(hadithService.findById(model.hadithId), userService.findById(model.userId))
        newItem.status = model.status
        return service.create(newItem)
    }

    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody model: SavesModel): SavesEntity {
        val item = findById(id)
        item.hadyth = hadithService.findById(model.hadithId)
        item.user = userService.findById(model.userId)
        item.status = model.status
        return service.update(item)
    }
}