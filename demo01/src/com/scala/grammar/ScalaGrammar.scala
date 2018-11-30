package com.scala.grammar

/**
  * Scala 定义了两种类型的变量 val 和 var，val 类似于 Java 中的 final 变量，
  * 一旦初始化之后，不可以重新复制（我们可以称它为常变量）。
  * 而 var 类似于一般的非 final 变量。可以任意重新赋值。
  *
  * scala> val msg="Hello,World"
  * msg: String = Hello,World
  *
  * 这个表达式定义了一个 msg 变量，为字符串常量。它的类型为 string (java.lang.string)。
  * 可以看到我们在定义这个变量时并不需要像 Java 一样定义其类型，Scala 可以根据赋值的内容推算出变量的类型。
  * 这在 Scala 语言中成为 “type inference”。
  * 当然如果你愿意，你也可以采用和 Java 一样的方法，明确指定变量的类型，如
  *
  * scala> val msg2:String ="Hello again,world"
  * msg2: String = Hello again,world
  *
  * 如果用_初始化数据，必须指定其数据类型，因为scala在推测数据类型的时候就是依照其数据来进行推测的
  * 但是此处的_赋值是根据不同的数据类型初始化不同的数据，虽然可以通过编译，但是运行的时候报异常
  * var sum = _
  *
  * 注：在scala中不需要用“;”结尾，如果多条语句在一行实现，那么此时必须用“;”隔开
  * scala的宗旨：能简单尽量简单，能少敲代码尽量少敲
  *
  */
object ScalaGrammar {

    // 定义常量或者变量可以指定其声明的类型，当然也可以不声明，不声明scala会对声明常量或者变量进行类型推断
    // val是定义常量的，而var是定义变量的
    // 定义未指定类型的常量
    val str = "hello world"
    // 定义指定类型的常量
    val str01: String = "hello scala"

    // 定义未指定类型的变量
    var str02: String = "hello scala01"
    // 定义指定类型的变量
    var str03: String = "hello scala02"

    // 开启scala学习之旅
    def main(args: Array[String]): Unit = {
        println("开启Scala学习之旅!")
        // 默认值输出
        val students = new Students("李四", 33)
        println(students.name)
    }

}
