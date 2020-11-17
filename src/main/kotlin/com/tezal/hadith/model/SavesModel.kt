package com.tezal.hadith.model

import com.tezal.hadith.enum.StatusList

data class SavesModel(
        val status: StatusList,
        val hadithId: Long,
        val userId: Long
)