package com.mytests.spring.kotlinDSL

import org.springframework.web.servlet.function.router

fun myRouter() = router {
    GET("/") {
        ok().body("hello")
    }

}
