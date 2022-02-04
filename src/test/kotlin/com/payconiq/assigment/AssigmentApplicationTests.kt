package com.payconiq.assigment


import com.payconiq.assigment.domain.stock.entity.Stock
import com.payconiq.assigment.domain.stock.repository.StockRepository
import com.payconiq.assigment.domain.stock.vo.StockVo
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal
import kotlin.test.assertEquals
import kotlin.test.assertNotNull


@SpringBootTest(
    classes = [AssigmentApplication::class],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = ["test"])
@AutoConfigureMockMvc

class AssigmentApplicationTests {
    @Autowired
    lateinit var restTemplate: TestRestTemplate
    @Autowired
    lateinit var repo: StockRepository
    @Test
    fun getListOfStocks() {
        val result = restTemplate.getForEntity("/api/stocks", List::class.java);
        assertNotNull(result)
        assertEquals(HttpStatus.OK, result.statusCode)
    }
    @Test
    fun getOneStock() {
        val result = restTemplate.getForEntity("/api/stocks/1", Stock::class.java);
        assertNotNull(result)
        assertEquals(HttpStatus.OK, result.statusCode)
    }

    @Test
    fun deleteOneStock() {
        val result = restTemplate.delete("/api/stocks/1", String()::class.java);
        assertNotNull(result)
    }

    @Test
    fun updateOneStock() {
        val result = restTemplate.patchForObject(
            "/api/stocks/1?_method=patch",
            StockVo(name="mackBookPro", currentPrice = BigDecimal(121212)),
            String()::class.java);

        assertEquals(repo.findById(1).get().currentPrice,BigDecimal("121212.00"))
    }

    @Test
    fun createOneStock() {
        val result = restTemplate.postForEntity("/api/stocks",StockVo(name="mackBookPro", currentPrice = BigDecimal(121212)), String()::class.java);
        assertNotNull(repo.findByName("mackBookPro"))
    }
}
