package com.scala.combination_extends

/**
  * 其中 extends 具有两个功效，
  * 一是让 ArrayElement 继承所有 Element 类的非私有成员，
  * 第二使得 ArrayElement 成为 Element 的一个子类。
  * 而 Elemen t称为 ArrayElement 的父类。
  *
  * 和 Java 稍有不同的一点是，Scala 中成员函数和成员变量地位几乎相同，而且也处在同一个命名空间，也就是 Scala 中不允许定义同名的成员函数和成员变量，
  * 但带来的一个好处是，可以使用成员变量来重载一个不带参数的成员函数。比如，接着前面的例子，你可以通过一个成员变量来实现基类中定义的抽象函数 contents。
  *
  * @param conts 主构造器的参数
  */
class ArrayElement(conts: Array[String]) extends Element {

    // override def contents: Array[String] = conts
    // 可以用变量实现抽象类中的抽象方法，同样可以用override修饰
    override val contents: Array[String] = conts

    // 可以看到，这是使用成员变量来实现基类中不带参数的抽象函数的一个非常恰当的例子。
    // Scala 中的这种实现是 Java 语言所不支持的，一般来说只有两个不同的命名空间来定义类，而 Java 可以有四个，Scala 支持的两个命名空间如下：
    // 值（字段，方法，包还有单例对象）
    // 类型（类和Trait名）
    // Scala 把字段和方法放进同一个命名空间的理由很清楚，因为这样你就可以使用 val 重载无参数的方法。
    override def demo(): Unit = {
        println("this is ArrayElement")
    }

}

object ArrayElement {

    def main(args: Array[String]): Unit = {
        val ae = new ArrayElement(Array("hello","world"))
        println(ae.height + " " + ae.width)
    }

}
