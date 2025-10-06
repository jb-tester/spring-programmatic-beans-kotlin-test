package com.mytests.spring.kotlinDSL


class Boo(val foo1: Foo1, val foo2:Foo2, val foo3:Foo3, val foo4:Foo4, val foo5:Foo5, val foo6:Foo6, val foo7:Foo7) {
    override fun toString(): String {

        return "Boo: $foo1, $foo2, $foo3, $foo4, $foo5, $foo6, $foo7"
    }
}