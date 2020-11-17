package com.tezal.hadith.service

interface BaseService<T> {
    fun findAll(): List<T>

    fun create(model: T): T

    fun update(model: T): T

    fun findById(id: Long): T

    fun deleteById(id: Long)
}