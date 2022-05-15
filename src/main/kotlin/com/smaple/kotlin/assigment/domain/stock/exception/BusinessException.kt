package com.smaple.kotlin.assigment.domain.stock.exception

open class BusinessException(message: String?,code:Int) : RuntimeException(message) {
}