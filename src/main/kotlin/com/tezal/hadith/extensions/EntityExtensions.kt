package com.tezal.hadith.extensions

import com.tezal.hadith.entity.*
import com.tezal.hadith.model.dto.*


fun HadithEntity.toDto() = HadithDto(
        id!!, title, description,
        status.name, category.id!!,
        category.title, book.id!!, book.title,
        sources?.map { it.toDto() }
)


fun SavesEntity.toDto() = SavesDto(
        id!!, createDate, updateDate,
        hadyth.id!!, hadyth.title,
        user.id!!, user.userName
)

fun UserEntity.toDto() = UserDto(
        id!!, createDate, updateDate, userName, password,
        settingEntity?.id, loginEntity?.id
)

fun BookEntity.toDto() = BookDto (
        id!!, title, description, author
)

fun SourceEntity.toDto() = SourceDto (id!!, title)