package com.mytests.spring.kotlinDSL

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(NewBeanRegistrar::class)
class NewBeanRegisrarConfiguration {
}