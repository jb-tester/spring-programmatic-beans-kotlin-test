package com.mytests.spring.kotlinDSL

import org.springframework.beans.factory.BeanRegistrar
import org.springframework.beans.factory.BeanRegistry
import org.springframework.core.ParameterizedTypeReference
import org.springframework.core.env.Environment
import kotlin.jvm.java


class NewBeanRegistrar : BeanRegistrar {
    override fun register(
        registry: BeanRegistry,
        env: Environment
    ) {

        // autowiring by type and by type+name don't work:
        // also, detected bean names ar T#0, T#1, ...
        registry.registerBean("clazz1", Clazz1::class.java)
        registry.registerBean(Clazz2::class.java)
        registry.registerBean("zxcv1", Zxcv1::class.java)
        registry.registerBean( Zxcv2::class.java)

        // if customizer is used, autowiring works:
        // but the names are still incorrect - T#4, T#5, ...
        // https://youtrack.jetbrains.com/issue/IDEA-385864
        registry.registerBean("zxcvPrim", Zxcv3::class.java) { spec ->
            spec.supplier { Zxcv3("zxcvPrim") }
            spec.primary()
        }
        registry.registerBean("zxcv3", Zxcv3::class.java) { spec ->
            spec.supplier { Zxcv3("zxcv3") }
        }

        registry.registerBean("zxcv4", ZxcvService::class.java) { spec ->
            spec.supplier { Zxcv4("zxcv4") }
        }

        // java.utilList#0
        registry.registerBean("zxcv5List", object : ParameterizedTypeReference<List<Zxcv5>>() {}) { spec ->
            spec.supplier { listOf<Zxcv5>( Zxcv5("aaa"), Zxcv5("bbb"), Zxcv5("ccc")) }
        }

    }
}