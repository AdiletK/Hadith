package com.tezal.hadith.entity

import com.tezal.hadith.enums.StatusList
import lombok.Getter
import lombok.Setter
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Getter
@Setter
@MappedSuperclass
abstract class BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: Long? = null

    @CreationTimestamp
    @Column(name = "create_date")
    val createDate: LocalDateTime = LocalDateTime.now()

    @UpdateTimestamp
    @Column(name = "update_date")
    val updateDate: LocalDateTime = createDate

    @Column(name = "status")
    var status: StatusList = StatusList.ENABLED

}