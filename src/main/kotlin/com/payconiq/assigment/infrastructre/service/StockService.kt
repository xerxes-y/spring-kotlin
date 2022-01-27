package com.payconiq.assigment.infrastructre.service

import com.payconiq.assigment.application.stock.controller.StockServices
import com.payconiq.assigment.domain.stock.entity.Stock
import com.payconiq.assigment.domain.stock.exception.StockNotFoundException
import com.payconiq.assigment.domain.stock.repository.StockRepository
import com.payconiq.assigment.domain.stock.vo.StockVo
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class StockService(private val stockRepository: StockRepository) : StockServices {
    override fun getStocks(pageNumber: Int, pageSize: Int): List<StockVo> {
        return stockRepository.findAllByDeletedIsFalse(PageRequest.of(pageNumber-1, pageSize)).map { stocks ->
            return@map stocks.map {
                return@map StockVo(it.id, it.name!!, it.currentPrice!!, it.lastUpdate!!)
            }
        }.orElseThrow { StockNotFoundException("Stock not found", 404) }
    }

    override fun updateStock(id: Int, stock: StockVo): Int {
        return stockRepository.findByIdAndDeletedIsFalse(id).map { lastStock ->
            return@map stockRepository.save(
                lastStock.copy(
                    id = lastStock.id,
                    name = stock.name,
                    currentPrice = stock.currentPrice,
                    lastUpdate = LocalDateTime.now()
                )
            ).id
        }.orElseThrow { StockNotFoundException("Stock not found", 404) }
    }

    override fun deleteStock(id: Int): Int {
        return stockRepository.findByIdAndDeletedIsFalse(id).map { lastStock ->
            return@map stockRepository.save(
                lastStock.copy(
                    deleted = true, lastUpdate = LocalDateTime.now()
                )
            ).id
        }.orElseThrow { StockNotFoundException("Stock not found", 404) }
    }

    override fun getOneStock(id: Int): StockVo {
        return stockRepository. findByIdAndDeletedIsFalse(id).map { lastStock ->
            return@map StockVo(lastStock.id, lastStock.name!!, lastStock.currentPrice!!, lastStock.lastUpdate!!)
        }.orElseThrow { StockNotFoundException("Stock not found", 404) }
    }

    override fun createStock(stock: StockVo): Int {
        return stockRepository.save(
            Stock(
                name = stock.name, currentPrice = stock.currentPrice, lastUpdate = LocalDateTime.now(), deleted = false
            )
        ).id

    }
}