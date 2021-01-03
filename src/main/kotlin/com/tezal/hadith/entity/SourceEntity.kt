package com.tezal.hadith.entity

import javax.persistence.*

@Entity
@Table(name= "source_table")
data class SourceEntity(
        @Column(unique = true)
         var title : String,
        @ManyToMany
        @JoinTable(name = "source_hadith",
                joinColumns = [JoinColumn(name = "source_id")],
                inverseJoinColumns = [JoinColumn(name = "hadith_id")])
        var hadiths: List<HadithEntity>,
        @ManyToOne val language: LanguageEntity?
) : BaseEntity()