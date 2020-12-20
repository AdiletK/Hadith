package com.tezal.hadith.service.common

import com.tezal.hadith.entity.BookEntity
import com.tezal.hadith.repo.BookRepo
import com.tezal.hadith.service.base.BaseServiceImpl
import org.springframework.stereotype.Service

@Service
class BookService(val repository: BookRepo) : BaseServiceImpl<BookEntity>(repository){

}