package com.payconiq.assigment.domain.stock.vo

import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDateTime
@Schema(description = "Model for a dealer's view of a stocks.")
data class StockVo(val id:Int=0,
                   val name: String,
                   @field:Schema(
                       description = "this is price for product",
                       example = "1212121.00",
                       type = "Big Decimal",
                       minimum = "-1",
                       maximum = " 2^2147483647-1"
                   )
                   val currentPrice: BigDecimal,
                   val lastUpdate: LocalDateTime?=null)