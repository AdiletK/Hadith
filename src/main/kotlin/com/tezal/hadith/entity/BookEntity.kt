package com.tezal.hadith.entity

import org.hibernate.annotations.Type
import javax.persistence.*

@Entity
@Table(name = "book_table")
data class BookEntity(
        val title: String,
        @Lob
        @Type(type = "org.hibernate.type.TextType")
        val description: String,
        val author: String,
        @ManyToOne val language: LanguageEntity?
) : BaseEntity()