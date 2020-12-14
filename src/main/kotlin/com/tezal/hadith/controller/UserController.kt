package com.tezal.hadith.controller

import com.tezal.hadith.entity.UserEntity
import com.tezal.hadith.service.BaseServiceImpl
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController(val service: BaseServiceImpl<UserEntity>) : BaseController<UserEntity>(service){

    @Secured("ROLE_ADMIN")
    override fun findAll(): List<UserEntity> {
        return service.findAll()
    }


}