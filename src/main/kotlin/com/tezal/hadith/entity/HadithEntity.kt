package com.tezal.hadith.entity

import org.hibernate.annotations.Type
import javax.persistence.*

@Entity
@Table(name = "hadith_table")
data class HadithEntity(
        @Lob
        @Type(type = "org.hibernate.type.TextType")
        var transcipt: String?,
        var imageUrl : String?,
        @ManyToMany(mappedBy = "categories") var categories: List<CategoryEntity>,
        @ManyToOne var book: BookEntity,
        @ManyToMany(mappedBy = "hadiths")
        var sources: List<SourceEntity>?
) : BaseEntity()
