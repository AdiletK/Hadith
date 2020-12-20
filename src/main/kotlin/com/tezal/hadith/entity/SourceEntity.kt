package com.tezal.hadith.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name= "source_table")
data class SourceEntity(
        @Column(unique = true)
         var title : String,
        @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        @JoinTable(name = "source_hadith",
                joinColumns = [JoinColumn(name = "source_id")],
                inverseJoinColumns = [JoinColumn(name = "hadith_id")])
        @JsonIgnoreProperties("sources")
        var hadiths: List<HadithEntity> = mutableListOf()
) : BaseEntity()