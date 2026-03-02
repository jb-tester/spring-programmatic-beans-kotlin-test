package com.mytests.spring.kotlinDSL

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import java.util.function.Supplier


@RestController
@RequestMapping("/ctor")
class AutowireAllCtorController(
    private val s: String,

    // different registerBean methods, explicit names:
    private val foo1: Foo1,
    private val foo2: Foo2,
    private val foo3: Foo3,
    private val foo4: Foo4,
    private val foo8: Supplier<Foo8>,

    // multiple dependencies:
    private val boo: Boo,

    // primary:
    private val bar1: Bar1,

    // fallback:
    private val bar2: Bar2,

    // conditional, profile specific:
    private val dummy: DummyService,
    
    // conditional, if-else-if-else:
    private val qwerty: QwertyService,

    // conditional, when-else
    private val asdf: AsdfService,

    private val confProperties: ConfProperties,

    private val zxcv1: Zxcv1,
    private val zxcv2: Zxcv2,
    private val clazz1: Clazz1,
    private val clazz2: Clazz2,

    // conditional:
    private val zxcv5_List: List<Zxcv5>,

    private val zxcv3Any: Zxcv3,
    private val zxcv: ZxcvService,

    @Qualifier("zxcv3") private val zxcv3: Zxcv3
) {

    // interface-type beans instantiated by specific implementation: autowiring fails
    // https://youtrack.jetbrains.com/issue/IDEA-385860
    /*@Autowired private lateinit var buzz3: Buzz3
    @Autowired private lateinit var buzz2: Buzz2
    @Autowired private lateinit var buzz1: Buzz1*/

    // @Autowired private lateinit var zxcv4: Zxcv4

    @GetMapping("/all")
    fun getAllItems(): ResponseEntity<String> {
        return ResponseEntity.ok(s)
    }

}


