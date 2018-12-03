package com.scala.data

/**
  * 数据类型:
  * Scala 提供了丰富的运算符用来操作前面介绍的基本数据类型。
  * 前面说过，这些运算符（操作符）实际为普通类方法的简化（或者称为美化）表示。
  * 比如 1+2 ，实际为 (1).+(2) ，也就是调用 Int 类型的+方法。
  *
  *
  */
object DataType {

    def main(args: Array[String]): Unit = {
        // 是否是操作符取决于你如何使用这个方法，当你使用 s.indexOf(‘o’) indexOf 不是一个运算符。
        // 而你写成 s indexOf ‘o’ ,indexOf 就是一个操作符，因为你使用了操作符的语法。
        // 除了类似+的中缀运算符（操作符在两个操作符之间），还可以有前缀运算符和后缀运算符。
        // 顾名思义前缀运算符的操作符在操作数前面，比如 -7 的“-”。
        // 后缀运算符的运算符在操作数的后面，比如 7 toLong 中的 toLong。
        // 前缀和后缀操作符都使用一个操作数，而中缀运算符使用前后两个操作数。
        // Scala 在实现前缀和后缀操作符的方法，其方法名都以 unary_-开头。

        // 是方法的调用
        val sum = (1).+(2)
        // 是操作符的调用
        val sum01 = 1 + 2

        val str = "hello scala"
        // 现在的indexOf就是操作符
        val ch = str indexOf 'o'
        println(ch)

        // 如果你需要定义前缀方法，你只能使用+,-,! 和～四个符号作为前缀操作符。
        // 后缀操作符在不使用.和括号调用时不带任何参数。
        // 在 Scala 中你可以省略掉没有参数的方法调用的空括号。
        // 按照惯例，如果你调用方法是为了利用方法的“副作用”，此时写上空括号，
        // 如果方法没有任何副作用（没有修改其它程序状态），你可以省略掉括号(在命令窗口可以省略，在代码中不能省略)。
        val s = "Hello World"
        val lower = s toLowerCase()
        println(lower)

        // 在scala中，逻辑运算支持“短路运算”，比如 op1 || op2 ，当 op1=true ，
        // op2 无需再计算，就可以知道结果为 true。这时 op2 表示式不会执行。
        // 与java中一样
        val op1 = true
        val op2 = true
        if (op1 || op2) {
            println("op1 || op2，当op1=true，op2无需再计算，就可以知道结果为true。这时op2 表示式不会执行")
        }

    }

}
