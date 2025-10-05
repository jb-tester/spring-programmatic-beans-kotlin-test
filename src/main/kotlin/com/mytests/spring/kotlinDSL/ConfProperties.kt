package com.mytests.spring.kotlinDSL

import org.springframework.boot.context.properties.ConfigurationProperties


@ConfigurationProperties(prefix = "custom.config")
class ConfProperties(var p1: String, var p2: String)
