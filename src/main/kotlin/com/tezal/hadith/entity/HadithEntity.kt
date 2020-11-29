package com.tezal.hadith.entity

import com.fasterxml.jackson.annotation.JsonIgnore
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
        @ManyToOne var book: BookEntity
) : BaseEntity()
