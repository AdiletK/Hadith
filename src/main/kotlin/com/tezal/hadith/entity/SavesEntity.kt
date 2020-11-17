package com.tezal.hadith.entity

import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "saves_table")
class SavesEntity (
        @ManyToOne var hadyth: HadithEntity,
        @ManyToOne var user: UserEntity
) : BaseEntity() {
}