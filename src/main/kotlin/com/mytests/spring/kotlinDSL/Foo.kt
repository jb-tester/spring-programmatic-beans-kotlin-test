package com.mytests.spring.kotlinDSL


class Foo1 {
    override fun toString(): String {
        return "foo1"
    }
}
class Foo2 {
    override fun toString(): String { return "foo2"}
}
class Foo3 {
    override fun toString(): String { return "foo3"}
}
class Foo4 {
    override fun toString(): String { return "foo4"}
}
class Foo5 {
    override fun toString(): String { return "foo5"}
}
class Foo6(val str: String) {
    override fun toString(): String {
        return "foo6('$str')"
    }
}
class Foo7{
    override fun toString(): String { return "foo7"}
}

fun foo7(): Foo7 {
    return Foo7()
}