package com.mytests.spring.kotlinDSL

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringProgrammaticBeansKotlinTestApplication

fun main(args: Array<String>) {
    runApplication<SpringProgrammaticBeansKotlinTestApplication>(*args)
}
