package com.mytests.spring.kotlinDSL

import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.router

fun newRouter() =
    router {
        GET("/new/test/{id}") { ServerResponse.ok().body("get new test with id = ${it.pathVariable("id")}") }
        POST("/new/test") { ServerResponse.ok().body("post new test") }
    }

