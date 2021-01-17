package com.tezal.hadith.extensions

import com.tezal.hadith.entity.*
import com.tezal.hadith.model.dto.*


fun HadithEntity.toDto() = HadithDto(
        id!!,
        status.name, categories.map { it.toDto() },
         book.id!!, book.title,
        sources?.map { it.toDto() }, imageUrl, transcipt
)


fun SavesEntity.toDto() = SavesDto(
        id!!,
        hadyth.id!!,
        user.id!!, user.userName
)

fun UserEntity.toDto() = UserDto(
        id!!, createDate, updateDate, userName, password,
        settingEntity?.id, loginEntity?.id
)

fun BookEntity.toDto() = BookDto(
        id!!, title, description, author, language?.id,
        language?.title
)

fun SourceEntity.toDto() = SourceDto(id!!, title, language?.id, language?.title)

fun CategoryEntity.toDto() = CategoryDto(id!!, title, status, language?.id, language?.title)

fun HadithTranslateEntity.toDto() = HadithTranslateDto(
        id!!, hadith.id ,title, description, language.id!!,
        language.title, status)