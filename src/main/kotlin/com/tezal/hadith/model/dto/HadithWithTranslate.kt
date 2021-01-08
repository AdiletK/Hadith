package com.tezal.hadith.model.dto

data class HadithWithTranslate(
        var hadith: HadithDto,
        var translate: List<HadithTranslateDto>
)