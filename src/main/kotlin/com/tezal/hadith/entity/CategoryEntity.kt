package com.tezal.hadith.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name= "category_table")
data class CategoryEntity(
        @Column(unique = true)
         var title : String
) : BaseEntity()