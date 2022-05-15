package com.smaple.kotlin.assigment.domain.stock.repository

import com.smaple.kotlin.assigment.domain.stock.entity.Stock
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import java.util.*

interface StockRepository : CrudRepository<Stock,Int> {
    fun findAllByDeletedIsFalse(pageable: Pageable): Optional<List<Stock>>
    fun findByIdAndDeletedIsFalse(id:Int) : Optional<Stock>
    fun findByName(name: String): Optional<Stock>

}