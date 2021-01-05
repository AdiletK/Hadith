package com.tezal.hadith.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "category_table")
data class CategoryEntity(
        @Column(unique = true)
        var title: String,
        @ManyToOne
        var language: LanguageEntity?
) : BaseEntity()