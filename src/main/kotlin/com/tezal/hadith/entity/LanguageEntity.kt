package com.tezal.hadith.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "lang_table")
data class LanguageEntity(
        @Column(unique = true)
        var title : String
) : BaseEntity()