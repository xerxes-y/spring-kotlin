package com.smaple.kotlin.assigment.domain.stock.exception

open class StockNotFoundException(message: String?,code:Int) : BusinessException(message,code) {
}