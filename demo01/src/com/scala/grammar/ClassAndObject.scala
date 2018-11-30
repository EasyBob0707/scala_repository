package com.scala.grammar

/**
  * 类与对象：
  *
  * 可以看到 Scala 类定义和 Java 非常类似，也是以 class 开始，和 Java 不同的，
  * Scala 的缺省修饰符为 public ，
  * 也就是如果不带有访问范围的修饰符 public,protected,private，Scala 缺省定义为 public。类的方法以 def 定义开始，
  * 要注意的 Scala 的方法的参数都是 val 类型，而不是 var 类型，因此在函数体内不可以修改参数的值。
  *
  * 类的方法分两种，一种是有返回值的，一种是不含返回值的，没有返回值的主要是利用代码的“副作用”，
  * 比如修改类的成员变量的值或者读写文件等。
  * Scala 内部其实将这种函数的返回值定为 Unit（类同 Java 的 void 类型），
  * 对于这种类型的方法，可以省略掉“=”号，因此如果你希望函数返回某个值，但忘了方法定义中的“=”，
  * Scala 会忽略方法的返回值，而返回 Unit。
  * 再强调一下，Scala 代码无需使用“；”结尾，也不需要使用 return返回值，函数的最后一行的值就作为函数的返回值。
  * 但如果你需要在一行中书写多个语句，此时需要使用“；”隔开，不过不建议这么做。
  */
object ClassAndObject {

    def main(): Unit = {

    }

    // 在scala中方法中的参数都是val修饰的，是不可以修改的。比如如果你修改 add 方法如下：
    // 编译报异常
    def add(b: Byte): Unit = {
        // b = 2
    }
}
