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
        @ManyToMany
        @JoinTable(
                name = "hadith_book",
                joinColumns = [JoinColumn(name = "book_id")],
                inverseJoinColumns = [JoinColumn(name = "hadith_id")])
        val books: Set<BookEntity>
) : BaseEntity()
