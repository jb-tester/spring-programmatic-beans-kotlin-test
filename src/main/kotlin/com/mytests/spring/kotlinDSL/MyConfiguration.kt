package com.mytests.spring.kotlinDSL

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(MyBeanRegistrar::class)
class MyConfiguration {
}