package com.tezal.hadith.model.dto

data class BookDto(
        val id: Long?,
        val title: String,
        val description: String,
        val author: String,
){
    constructor()
}