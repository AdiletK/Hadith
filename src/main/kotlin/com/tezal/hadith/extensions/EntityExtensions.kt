package com.tezal.hadith.extensions

import com.tezal.hadith.entity.*
import com.tezal.hadith.model.dto.*
import com.tezal.hadith.model.dto.mobile.BookMobileDto
import com.tezal.hadith.model.dto.mobile.General


fun HadithEntity.toDto() = HadithDto(
        id!!,
        status.name, imageUrl, transcipt
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

fun BookEntity.toMobileDto() = BookMobileDto(id!!, title, description)

fun SourceEntity.toDto() = SourceDto(id!!, title, language?.id, language?.title)
fun SourceEntity.toMobileDto() = General(id!!, title)

fun CategoryEntity.toDto() = CategoryDto(id!!, title, status, language?.id, language?.title, position, book.id)
fun CategoryEntity.toMobileDto() = General(id!!, title)

fun HadithTranslateEntity.toDto() = HadithTranslateDto(
        id!!, hadith.id, title, description, language.id!!,
        language.title, status, source?.id!!, source?.title,  categories.map { it.id!! }, position)
