package com.mytests.spring.kotlinDSL

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertNotNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.util.function.Supplier
import kotlin.test.assertEquals

@SpringBootTest
@ActiveProfiles("p2")
class SpringProgrammaticBeansKotlinTestApplicationTests {

    @Autowired private lateinit var s: String

    // different registerBean methods, explicit names:
    @Autowired private lateinit var foo1: Foo1
    @Autowired private lateinit var foo2: Foo2
    @Autowired private lateinit var foo3: Foo3
    @Autowired private lateinit var foo4: Foo4
    @Autowired private lateinit var foo5: Foo5
    @Autowired private lateinit var foo6: Foo6
    @Autowired private lateinit var foo7: Foo7
    @Autowired private lateinit var foo8: Supplier<Foo8>
    @Autowired private lateinit var foo9: Foo9

    // multiple dependencies:
    @Autowired private lateinit var boo: Boo

    // primary:
    @Autowired private lateinit var bar1: Bar1

    // fallback:
    @Autowired private lateinit var bar2: Bar2

    // conditional, profile specific:
    @Autowired private lateinit var buzz: BuzzService

    // instantiated by specific implementation:
    @Autowired private lateinit var buzz3: Buzz3
    @Autowired private lateinit var buzz2: Buzz2


    @Autowired private lateinit var confProperties: ConfProperties

    @Test
    fun testNotNullBeans() {
        assertNotNull(s)
        assertNotNull(foo1)
        assertNotNull(foo2)
        assertNotNull(foo3)
        assertNotNull(foo4)
        assertNotNull(foo5)
        assertNotNull(foo6)
        assertNotNull(foo7)
        assertNotNull(foo8)
        assertNotNull(foo9)
        assertNotNull(boo)
        assertNotNull(bar1)
        assertNotNull(bar2)
        assertNotNull(buzz)
        assertNotNull(buzz2)
        assertNotNull(buzz3)
    }

    @Test
    fun configPropsTest() {

        assertEquals("aaa", confProperties.p1)
        assertEquals("bbb", confProperties.p2)
    }
}
