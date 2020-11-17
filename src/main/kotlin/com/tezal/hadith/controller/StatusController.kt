package com.tezal.hadith.controller

import com.tezal.hadith.enum.StatusList
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/status")
class StatusController {
    @GetMapping("/findAll")
    fun findAll(): Array<StatusList> {
        return StatusList.values();
    }
}