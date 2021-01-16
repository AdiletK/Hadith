package com.tezal.hadith.entity

import javax.persistence.*

@Entity
@Table(name = "category_table")
data class CategoryEntity(
        @Column(unique = true)
        var title: String,
        @ManyToOne
        var language: LanguageEntity?,
        @ManyToMany
        @JoinTable(name = "category_hadith",
                joinColumns = [JoinColumn(name = "category_id")],
                inverseJoinColumns = [JoinColumn(name = "hadith_id")])
        var categories: List<HadithEntity>?
) : BaseEntity()