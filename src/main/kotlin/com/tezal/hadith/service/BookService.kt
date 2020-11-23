package com.tezal.hadith.service

import com.tezal.hadith.entity.BookEntity
import com.tezal.hadith.entity.HadithEntity
import com.tezal.hadith.repo.BookRepo
import com.tezal.hadith.repo.HadithRepo
import org.springframework.stereotype.Service

@Service
class BookService(val repository: BookRepo) : BaseServiceImpl<BookEntity>(repository){

}