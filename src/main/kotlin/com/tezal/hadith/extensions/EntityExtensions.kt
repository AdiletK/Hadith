package com.tezal.hadith.extensions

import com.tezal.hadith.entity.BookEntity
import com.tezal.hadith.entity.HadithEntity
import com.tezal.hadith.entity.SavesEntity
import com.tezal.hadith.entity.UserEntity
import com.tezal.hadith.model.dto.BookDto
import com.tezal.hadith.model.dto.HadithDto
import com.tezal.hadith.model.dto.SavesDto
import com.tezal.hadith.model.dto.UserDto


fun HadithEntity.toDto() = HadithDto(
        id!!, title, description,
        createDate, updateDate, status.name,
        category.id!!, category.title, book.id!!, book.title
)


fun SavesEntity.toDto() = SavesDto(
        id!!, createDate, updateDate,
        hadyth.id!!, hadyth.title,
        user.id!!, user.userName
)

fun UserEntity.toDto() = UserDto(
        id!!, createDate, updateDate, userName,
        settingEntity.id!!, loginEntity.id!!
)

fun BookEntity.toDto() = BookDto (
        id!!, title, description, author
)