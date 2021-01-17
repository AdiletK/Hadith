package com.tezal.hadith.entity

import javax.persistence.*

@Entity
@Table(name = "category_table")
data class CategoryEntity(
        @Column(unique = true)
        var title: String,
        @ManyToOne
        var language: LanguageEntity?,
        @ManyToMany(mappedBy = "categories")
        var hadiths: List<HadithEntity>?,
) : BaseEntity()