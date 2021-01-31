package com.tezal.hadith.entity

import javax.persistence.*

@Entity
@Table(name= "source_table")
data class SourceEntity(
        @Column(unique = true)
         var title : String,
        @ManyToOne val language: LanguageEntity?
) : BaseEntity()