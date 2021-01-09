package com.tezal.hadith.model.dto

import com.tezal.hadith.enums.StatusList

data class CategoryDto(
        val id: Long,
        val title: String,
        val status: StatusList?,
        val langId: Long?,
        val langTitle: String?
        )