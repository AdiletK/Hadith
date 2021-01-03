package com.tezal.hadith.entity

import org.hibernate.annotations.Type
import javax.persistence.*

@Entity
@Table(name = "hadith_table")
data class HadithEntity(
        var title: String,
        @Lob
        @Type(type = "org.hibernate.type.TextType")
        var description: String,
        @ManyToOne var category: CategoryEntity,
        @ManyToOne var book: BookEntity,
        @ManyToMany(mappedBy = "hadiths")
        var sources: List<SourceEntity>?,
        @ManyToOne var language: LanguageEntity?
) : BaseEntity()
