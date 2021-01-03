package com.tezal.hadith.extensions

import com.tezal.hadith.entity.*
import com.tezal.hadith.model.dto.*


fun HadithEntity.toDto() = HadithDto(
        id!!, title, description,
        status.name, category.id!!,
        category.title, book.id!!, book.title,
        sources?.map { it.toDto() }, language?.title,
        language?.id, sources?.map { it.id } as List<Long>
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
        id!!, title, description, author, language?.id,
        language?.title
)

fun SourceEntity.toDto() = SourceDto (id!!, title, language?.id, language?.title)

fun CategoryEntity.toDto() = CategoryDto(id!!, title, status, language.id, language.title)