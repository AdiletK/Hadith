package com.tezal.hadith.entity

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name= "category_table")
data class CategoryEntity(
        var title : String
) : BaseEntity()