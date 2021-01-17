package com.tezal.hadith.entity

import org.hibernate.annotations.Type
import javax.persistence.*

@Entity
@Table(name = "hadith_table")
data class HadithEntity(
        @Lob
        @Type(type = "org.hibernate.type.TextType")
        var transcipt: String?,
        var imageUrl: String?,
        @ManyToMany
        @JoinTable(name = "category_hadith",
                joinColumns = [JoinColumn(name = "hadith_id")],
                inverseJoinColumns = [JoinColumn(name = "category_id")])
        var categories: List<CategoryEntity>,
        @ManyToOne var book: BookEntity,
        @ManyToMany(mappedBy = "hadiths")
        var sources: List<SourceEntity>?
) : BaseEntity()
