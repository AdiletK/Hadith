package com.tezal.hadith.controller.common

import com.tezal.hadith.entity.HadithEntity
import com.tezal.hadith.extensions.toDto
import com.tezal.hadith.model.HadithModel
import com.tezal.hadith.model.dto.HadithDto
import com.tezal.hadith.model.dto.HadithWithTranslate
import com.tezal.hadith.service.common.*
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/hadith")
class HadithController(val service: HadithService, val categoryService: CategoryService,
                       val bookService: BookService, val sourceService: SourceService,
                       val hadithTranslateService: HadithTranslateService) {

    @GetMapping("/findAll")
    fun findAll(): List<HadithWithTranslate> {
        val res: ArrayList<HadithWithTranslate> = ArrayList()
        val list = service.findAll().map { it.toDto() }
        list.forEach {
            res.add(HadithWithTranslate(it, hadithTranslateService.findByHadithId(it.id)))
        }
        return res
    }

    @GetMapping("/findByCatId/{id}")
    fun findAllByCatId(@PathVariable id: Long): List<HadithWithTranslate> {
        val res: ArrayList<HadithWithTranslate> = ArrayList()
        val list = service.findAllByCatId(id).map { it.toDto() }
        list.forEach {
            res.add(HadithWithTranslate(it, hadithTranslateService.findByHadithId(it.id)))
        }
        return res
    }

    @GetMapping("/findById/{id}")
    fun findById(@PathVariable id: Long): HadithWithTranslate {
        return HadithWithTranslate(service.findById(id).toDto(),
                hadithTranslateService.findByHadithId(id))
    }

//    @GetMapping("/findByLangId/{id}")
//    fun findByLangId(@PathVariable id: Long) : List<HadithDto>{
////        return service.findByLang(id);
//    }
//    @GetMapping("/findByLangCode/{code}")
//    fun findByLangCode(@PathVariable code: String) : List<HadithDto>{
//        return service.findByLang(code);
//    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/save")
    fun save(@RequestBody model: HadithModel): HadithDto {
        val newItem = HadithEntity(model.transcript, model.imageUrl,
                categoryService.findById(model.categoryId),
                bookService.findById(model.bookId),
                model.sourcesId?.map { sourceService.findById(it) })
        newItem.status = model.status
        val saved = service.create(newItem);
        hadithTranslateService.saveTranslates(model.translateDto, saved.id!!)
        return saved.toDto()
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody model: HadithModel): HadithDto {
        return service.update(convert(id, model)).toDto()
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long) {
        hadithTranslateService.deleteByHadithId(id)
        service.deleteById(id)
    }

    private fun convert(id: Long, model: HadithModel): HadithEntity {
        val item = service.findById(id)
        item.category = categoryService.findById(model.categoryId)
        item.book = bookService.findById(model.bookId)
        item.sources = model.sourcesId?.map { sourceService.findById(it) }
        item.imageUrl = model.imageUrl
        item.transcipt = model.transcript
        item.status = model.status
        return item
    }
}