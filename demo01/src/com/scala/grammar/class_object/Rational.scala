package com.scala.grammar.class_object

/**
  * 有理数的类
  *
  * 在类后面定义的构造器称为主构造器，其他的称为辅构造器  类参数又称之为主构造器的参数
  * 注意：主构造器一定要调用主构造器（直接调用或者间接调用都可以）
  * 主构造器中的参数不能与类中的成员变量参数名称一样， 辅构造器可以一样
  */
class Rational(n: Int, d: Int) {

    // 辅助构造器
    def this(n: Int) {
        // 调用主构造器
        this(n, 1)
    }

    // Scala 中解决这个问题的一个方法是使用 require 方法（require 方法为 Pre def对象的定义的一个方法，
    // Scala 环境自动载入这个类的定义，因此无需使用 import 引入这个对象）
    // 外界无法访问n与d
    require(d != 0)
    // 保存最大公倍数
    // abs()取绝对值
    private val g = gcd(n.abs, d.abs)
    val number = n / g
    val denom = d / g

    // 重写toString()方法
    override def toString: String = {
        number + "/" + denom
    }
    // 这样就可以使用 + 号来实现 Rational 的加法和乘法。
    // +，*的优先级是 Scala 预定的，和整数的+，-，* ，/的优先级一样。
    // 两个有理数相加
    // 和 Java 一样，Scala 也支持方法重载，重载的方法参数类型不同而使用同样的方法名称，
    // 比如对于 Rational 对象，+的对象可以为另外一个 Rational 对象，也可以为一个 Int 对象，此时你可以重载+方法以支持和 Int 相加。
    def +(that: Rational): Rational = {
        new Rational(number * that.denom + that.number * denom, denom * that.denom)
    }
    // 与上面的方法互为重载方法
    def +(i: Int): Rational = {
        new Rational (number + i * denom, denom)
    }

    def * (that:Rational) = {
        new Rational(number * that.number, denom * that.denom)
    }

    // scala中使用this来引用对象本身
    def lessThan(that: Rational) = {
        this.number * that.denom < that.number * this.denom
    }

    // 与上面的方法是等效的
    def lessThan02(that: Rational) = {
        number * that.denom < that.number * denom
    }

    // 如果this引用对象本身，则this无法省略
    def max(that: Rational) = {
        if (lessThan(that)) that else this
    }

    // 获取最大公约数
    private def gcd(a: Int, b: Int): Int = {
        if (b == 0) a else gcd(b, a % b)
    }

    println("Create: " + number + "/" + denom)

    // 其实此时 Rational 的一个+重载方法是多余的， 当 Scala 计算 2+ r，发现 2（Int)类型没有 可以和 Rational 对象相加的方法，
    // Scala 环境就检查 Int 的隐含类型转换方法是否有合适的类型转换方法，类型转换后的类型支持+r，
    // 一检查发现定义了由 Int 到 Rational 的隐含转换方法，就自动调用该方法，把整数转换为 Rational 数据类型，
    // 然后调用 Rational 对象的+ 方法。从而实现了 Rational 类或是 Int 类的扩展。关于 implicit def 的详细介绍将由后面的文章来说明，
    // 隐含类型转换在设计 Scala 库时非常有用。
    implicit def intToRational(x: Int): Rational = {
        new Rational(x)
    }

}

object Rational {

    def main(args: Array[String]): Unit = {
        // 在创建Rational对象时自动调用打印的方法
        val rat: Rational = new Rational(2, 88)
    }

}
