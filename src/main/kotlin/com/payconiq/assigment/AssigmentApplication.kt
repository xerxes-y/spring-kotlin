package com.payconiq.assigment

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class AssigmentApplication

fun main(args: Array<String>) {
	runApplication<AssigmentApplication>(*args)
}
