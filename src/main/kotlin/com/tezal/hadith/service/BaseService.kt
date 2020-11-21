package com.tezal.hadith.service

interface BaseService<ENTITY> {
    fun findAll(): List<ENTITY>

    fun create(model: ENTITY): ENTITY

    fun update(model: ENTITY): ENTITY

    fun findById(id: Long): ENTITY

    fun deleteById(id: Long)
}