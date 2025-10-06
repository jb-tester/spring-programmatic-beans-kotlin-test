package com.mytests.spring.kotlinDSL

import org.springframework.web.servlet.function.router

fun booRouter(boo: Boo)= router {
    GET("/boo") {
        ok().body(boo.toString())
    }

}
