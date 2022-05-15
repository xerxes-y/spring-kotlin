package com.smaple.kotlin.assigment.application.stock.controller

import com.smaple.kotlin.assigment.domain.stock.vo.StockVo

interface StockServices {
    fun getStocks(pageNumber: Int,pageSize:Int) : List<StockVo>
    fun updateStock(id: Int, stock: StockVo):Int
    fun deleteStock(id: Int):Int
    fun getOneStock(id: Int) : StockVo
    fun createStock(stock: StockVo) : Int
}