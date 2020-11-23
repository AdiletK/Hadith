package com.tezal.hadith.repo

import com.tezal.hadith.entity.BookEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepo : JpaRepository<BookEntity, Long> {
}