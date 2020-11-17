package com.tezal.hadith.entity

import javax.persistence.Entity
import javax.persistence.Lob
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "hadith_table")
data class HadithEntity(
        var title: String,
        @Lob
        var description: String,
        @ManyToOne var category: CategoryEntity,
) : BaseEntity() {
}