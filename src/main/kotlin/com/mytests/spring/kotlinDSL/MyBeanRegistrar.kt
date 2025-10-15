package com.mytests.spring.kotlinDSL

import org.springframework.beans.factory.BeanRegistrarDsl
import java.util.function.Supplier

class MyBeanRegistrar : BeanRegistrarDsl({
    // bean is not recognized - fixed
    registerBean(supplier = { "foo!!!" })

    // different registerBean methods, explicit names:
    // ok:
    registerBean<Foo1>(name = "foo1")
    registerBean<Foo2>("foo2")
    // beans are not recognized - fixed
    registerBean("foo3") { Foo3() }
    registerBean(name ="foo4", supplier = { Foo4() })
    // bean is considered to be of type `kotlin.reflect.KFunction0<? extends com.mytests.spring.kotlinDSL.Foo5>`
    registerBean(f = ::Foo5, name = "foo5")
    // bean of Foo6 type is recognized, name is ignored - fixed
    registerBean<Foo6, String>(f = {str -> Foo6(str)}, name = "foo6")

    // bean is considered to be of type `kotlin.reflect.KFunction0<? extends com.mytests.spring.kotlinDSL.Foo9>`
    registerBean(f = Foo9Factory()::foo9, name = "foo9")

    // implicit name (com.mytests.spring.kotlinDSL.Foo7#0), type from function (Foo7) - not detected:
    // instead, the bean name is considered to be `foo7`, and type - `kotlin.reflect.KFunction0<? extends com.mytests.spring.kotlinDSL.Foo7>`
    registerBean(::foo7)

    // bean depends on all beans above
    registerBean<Boo> { Boo(bean(), bean(), bean(), bean(), bean(), bean(), bean()) }

    registerBean<Supplier<Foo8>>(name = "foo8supplier") {
        Supplier<Foo8> { Foo8() }
    }

    // primary bean is not detected:
    registerBean<Bar1>(name = "bar11", primary = true) { Bar1(bean<Foo1>(),1) }
    registerBean<Bar1>(name = "bar12") { Bar1(bean<Foo1>(),2) }
    registerBean<Bar1>(name = "bar13") { Bar1(bean<Foo1>(),3) }

    // fallback beans are not detected:
    registerBean<Bar2>(name = "bar21") { Bar2(bean<Foo1>(),1) }
    registerBean<Bar2>(name = "bar22", fallback = true) { Bar2(bean<Foo1>(),2) }
    registerBean<Bar2>(name = "bar23", fallback = true) { Bar2(bean<Foo1>(),3) }

    // conditions are ignored
    // beans autowiring by implementation type doesn't work
    profile("p1") {
        registerBean<BuzzService> { Buzz1("buzzP1") }
    }
    profile("p2") {
        registerBean<BuzzService> { Buzz2("buzzP2") }
    }
    registerBean<BuzzService>{ Buzz3("buzzzz") }

    // configurationProperties: ok
    registerBean<ConfProperties>()

    // routers: not detected - fixed
    registerBean(::myRouter)
    registerBean(::booRouter)
    registerBean(::newRouter)
})
