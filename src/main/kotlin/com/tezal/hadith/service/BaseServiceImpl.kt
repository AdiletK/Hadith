package com.tezal.hadith.service

import com.tezal.hadith.entity.BaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.lang.RuntimeException

 abstract class BaseServiceImpl<ENTITY: BaseEntity>(
         private var repository: JpaRepository<ENTITY, Long>)
     : BaseService<ENTITY> {


     override fun findAll(): List<ENTITY> {
        return repository.findAll()
    }

    override fun create(model: ENTITY): ENTITY {
        return repository.save(model)
    }

    override fun update(model: ENTITY): ENTITY {
        return repository.save(model)
    }

    override fun findById(id: Long): ENTITY {
        return repository.findById(id).orElseThrow { RuntimeException("Element not found!!!") }
    }

    override fun deleteById(id: Long) {
        repository.deleteById(id)
    }
}