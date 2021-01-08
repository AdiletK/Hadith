package com.tezal.hadith.entity

import org.hibernate.annotations.Type
import javax.persistence.Entity
import javax.persistence.Lob
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "hadith_translate_table")
data class HadithTranslateEntity(
        var title: String,
        @Lob
        @Type(type = "org.hibernate.type.TextType")
        var description: String,
        @ManyToOne var language: LanguageEntity,
        @ManyToOne var hadith: HadithEntity
) : BaseEntity()