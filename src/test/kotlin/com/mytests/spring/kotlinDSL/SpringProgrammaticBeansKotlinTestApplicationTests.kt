package com.mytests.spring.kotlinDSL

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertNotNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
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
    @Autowired private lateinit var foo8: Supplier<Foo8>
    // removed in the latest versions:
    //  @Autowired private lateinit var foo9: Foo9
    // @Autowired private lateinit var foo5: Foo5
    // @Autowired private lateinit var foo6: Foo6
    //  @Autowired private lateinit var foo7: Foo7

    // multiple dependencies:
    @Autowired private lateinit var boo: Boo

    // primary:
    @Autowired private lateinit var bar1: Bar1

    // fallback:
    @Autowired private lateinit var bar2: Bar2

    // conditional, profile specific:
    @Autowired private lateinit var dummy: DummyService
    // conditional, if-else-if-else:
    @Autowired private lateinit var qwerty: QwertyService
    // conditional, when-else
    @Autowired private lateinit var asdf: AsdfService

    // instantiated by specific implementation:
    @Autowired private lateinit var buzz3: Buzz3
    @Autowired private lateinit var buzz2: Buzz2
    @Autowired private lateinit var buzz1: Buzz1


    @Autowired private lateinit var confProperties: ConfProperties

    // see the cases from NewBeanRegistrar:
    // beans registered using registerBean(String name, Class<T> beanClass) or registerBean(Class<T> beanClass) are not resolved
    @Autowired private lateinit var zxcv1: Zxcv1
    @Autowired private lateinit var zxcv2: Zxcv2
    @Autowired private lateinit var clazz1: Clazz1
    @Autowired private lateinit var clazz2: Clazz2

    @Autowired private lateinit var zxcv5List: List<Zxcv5>;

    // ok if registerBean(String name, Class<T> beanClass, Consumer<Spec<T>> customizer);
    @Autowired private lateinit var zxcv3Any: Zxcv3 // navigates to primary - ok
    @Autowired private lateinit var zxcv4: Zxcv4
    @Autowired private lateinit var zxcv: ZxcvService

    // qualifier by name: since incorrect name is detected, autowiring fails
    @Autowired @Qualifier("zxcv3") private lateinit var zxcv3: Zxcv3

    @Test
    fun testNotNullBeans() {
        assertNotNull(s)
        assertNotNull(foo1)
        assertNotNull(foo2)
        assertNotNull(foo3)
        assertNotNull(foo4)
        assertNotNull(foo8)
        assertNotNull(boo)
        assertNotNull(bar1)
        assertNotNull(bar2)
        assertNotNull(dummy)
        assertNotNull(buzz1)
        assertNotNull(buzz2)
        assertNotNull(buzz3)
//        assertNotNull(foo5)
//        assertNotNull(foo6)
//        assertNotNull(foo7)
//        assertNotNull(foo9)
        assertNotNull(clazz1)
        assertNotNull(clazz2)
        assertNotNull(zxcv1)
        assertNotNull(zxcv2)
        assertNotNull(zxcv3)
        assertEquals("zxcv3", zxcv3.str)
        assertNotNull(zxcv3Any)
        assertEquals("zxcvPrim", zxcv3Any.str)
        assertNotNull(zxcv4)
        assertNotNull(zxcv)
        assertNotNull(zxcv5List)
        assertEquals(3, zxcv5List.size)
    }

    @Test
    fun configPropsTest() {

        assertEquals("aaa", confProperties.p1)
        assertEquals("bbb", confProperties.p2)
    }
}
