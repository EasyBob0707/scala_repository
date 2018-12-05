package com.scala.grammar

import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException
import java.net.{MalformedURLException, URL}

/**
  * scala异常处理
  * Scala 的异常处理和其它语言比如 Java 类似，一个方法可以通过抛出异常的方法而不返回值的方式终止相关代码的运行。
  * 调用函数可以捕获这个异常作出相应的处理或者直接退出，在这种情况下，异常会传递给调用函数的调用者，依次向上传递，直到有方法处理这个异常。
  */
class ScalaException {

    // 求偶数的一半
    // 当 n 为偶数时，n 初始化为 n 的一半，而如果 n 为奇数，
    // 将在初始化 half 之前就抛出异常，正因为如此，
    // 可以把 throw 的返回值的类型为任意类型。
    // 技术上来说，抛出异常的类型为 Nothing。
    // 对于说明的例子来说整个 if 表达式的类型为可以计算出值的那个分支的类型，
    // 如果 n 为 Int，那么 if 表示式的类型也是 Int 类型，而不需要考虑 throw 表达式的类型。
    def exceptionHandler(num: Int): Int = {
        if (num % 2 == 0) {
            num / 2
        } else {
            throw new RuntimeException("num must is even!")
        }
    }

    //模式匹配将在后面介绍，try-catch 表达式的基本用法和 Java 一样，如果 try 块中代码在执行过程中出现异常，
    // 将逐个检测每个 catch 块，在上面的例子，如果打开文件出现异常，将先检查是否是 FileNotFoundException 异常，
    // 如果不是，再检查是否是 IOException，如果还不是，在终止 try-catch 块的运行，而向上传递这个异常。
    // 注意：和 Java 异常处理不同的一点是，Scala 不需要你捕获 checked 的异常，这点和 C# 一样，
    // 也不需要使用 throw 来声明某个异常，当然如果有需要还是可以通过 @throw 来声明一个异常，但这不是必须的。
    def exceptionHandle02(): Unit = {
        try {
            val f = new FileReader("input.txt")
        } catch {
            // scala中的模式匹配
            case ex: FileNotFoundException => println("NOT THE FILES")
            case ex: IOException => println("IOException")
        }
    }

    // Scala 也支持 finally 语句，你可以在 finally 块中添加一些代码，这些代码不管 try 块是否抛出异常，
    // 都会执行。比如，你可以在 finally 块中添加代码保证关闭已经打开的文件，而不管前面代码中是否出现异常。
    // 与java一样，做一些结尾的工作，比如关闭流
    // 如果在finally中有return语句，则会返回finally中的值
    def exceptionFinally(): Unit = {
        val file = new FileReader("input.txt")
        try {
            //use the file
        } finally {
            file.close()
        }
    }

    // 和大部分Scala 控制结构一样，Scala 的 try-catch-finally 也生成某个值，比如下面的例子尝试分析一个 URL，如果输入的 URL 无效，则使用缺省的 URL 链接地址。
    def urlFor(path:String): Unit = {
        try {
            new URL(path)
        } catch {
            case e: MalformedURLException =>
                new URL("http://www.scala-lang.org")
        }
    }

}

object ScalaException {

    def main(args: Array[String]): Unit = {

    }

}
