package com.tezal.hadith.model.dto.mobile

data class HadithMobileApi(val id: Long,
                           val categories: List<Long>?,
                           val sourceId: Long?,
                           val title: String,
                           val description: String,
                           val imageUrl: String?,
                           val position:Int
)
