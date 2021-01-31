package com.tezal.hadith.entity

import org.hibernate.annotations.Type
import javax.persistence.*

@Entity
@Table(name = "hadith_translate_table")
data class HadithTranslateEntity(
        var title: String,
        @Lob
        @Type(type = "org.hibernate.type.TextType")
        var description: String,
        @ManyToOne(fetch = FetchType.LAZY) var language: LanguageEntity,
        @ManyToOne(fetch = FetchType.LAZY) var hadith: HadithEntity,
        @ManyToOne var book: BookEntity,
        @ManyToOne var source: SourceEntity
) : BaseEntity() {
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "hadith_category",
            joinColumns = [JoinColumn(name = "hadith_id")],
            inverseJoinColumns = [JoinColumn(name = "category_id")])
    var categories: List<CategoryEntity> = emptyList()
}