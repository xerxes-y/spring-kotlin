package com.payconiq.assigment.domain.stock.entity

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Stock(
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    val id:Int=0,
    val name: String?=null,
    val currentPrice: BigDecimal?=null,
    val lastUpdate: LocalDateTime?=null,
    val deleted : Boolean?=null
)
