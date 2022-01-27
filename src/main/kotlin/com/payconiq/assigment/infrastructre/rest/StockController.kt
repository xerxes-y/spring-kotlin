package com.payconiq.assigment.infrastructre.rest

import com.payconiq.assigment.domain.stock.vo.StockVo
import com.payconiq.assigment.infrastructre.service.StockService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/stocks")
class StockController(private val stockServices: StockService) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getStocks(@RequestParam(value = "number", required = false, defaultValue = "1") number:Int,
                  @RequestParam(value = "size", required = false, defaultValue = "10") size:Int):
            ResponseEntity<List<StockVo>> { return ResponseEntity.ok(stockServices.getStocks(number, size)) }
    @PatchMapping("/{id}",produces = [MediaType.APPLICATION_JSON_VALUE])
     fun updateStock(@PathVariable id: Int,@RequestBody  stock: StockVo) :ResponseEntity<String> {
        return ResponseEntity.ok("stock is updated with id : ${stockServices.updateStock(id,stock)}!") }
    @DeleteMapping("/{id}",produces = [MediaType.APPLICATION_JSON_VALUE])
     fun deleteStock(@PathVariable id: Int):ResponseEntity<String> {
        return ResponseEntity.ok("stock is deleted with id ${stockServices.deleteStock(id)}!") }
    @GetMapping("/{id}",produces = [MediaType.APPLICATION_JSON_VALUE])
     fun getOneStock(@PathVariable id: Int) : ResponseEntity<StockVo> {
        return ResponseEntity.ok(stockServices.getOneStock(id))
    }
    @PostMapping( produces = [MediaType.APPLICATION_JSON_VALUE])
     fun createStock(@RequestBody stock: StockVo):ResponseEntity<String> {
      return ResponseEntity
          .ok("the stock is created with id ${stockServices.createStock(stock)}!")
    }
}