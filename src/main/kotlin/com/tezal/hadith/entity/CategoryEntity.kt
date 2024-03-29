package com.tezal.hadith.entity

import javax.persistence.*

@Entity
@Table(name = "category_table")
data class CategoryEntity(
        @Column(unique = true)
        var title: String,
        @ManyToOne(fetch = FetchType.LAZY)
        var language: LanguageEntity?,
        @ManyToOne var book: BookEntity,
        var position: Int
) : BaseEntity() {
    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    var hadiths: List<HadithTranslateEntity>? = emptyList()
}