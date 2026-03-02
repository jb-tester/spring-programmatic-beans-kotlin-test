package com.mytests.spring.kotlinDSL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

@RestController
@RequestMapping("/field")
class AutowireAllFieldController {

    @Autowired
    private lateinit var s: String

    // different registerBean methods, explicit names:
    @Autowired private lateinit var foo1: Foo1
    @Autowired private lateinit var foo2: Foo2
    @Autowired private lateinit var foo3: Foo3
    @Autowired private lateinit var foo4: Foo4
    @Autowired private lateinit var foo8: Supplier<Foo8>

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


    @Autowired private lateinit var confProperties: ConfProperties


    @Autowired private lateinit var zxcv1: Zxcv1
    @Autowired private lateinit var zxcv2: Zxcv2
    @Autowired private lateinit var clazz1: Clazz1
    @Autowired private lateinit var clazz2: Clazz2

    // conditional:
    @Autowired private lateinit var zxcv5_List: List<Zxcv5>;

    @Autowired private lateinit var zxcv3Any: Zxcv3
    @Autowired private lateinit var zxcv: ZxcvService

    @Autowired @Qualifier("zxcv3") private lateinit var zxcv3: Zxcv3

    @GetMapping("/all")
    fun getAllItems(): ResponseEntity<String> {
        return ResponseEntity.ok(s)
    }

}
