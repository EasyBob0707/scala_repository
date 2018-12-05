package com.scala.grammar

import java.io.{BufferedReader, InputStreamReader}
import scala.util.control.Breaks._

/**
  * scala中为了不破坏函数的编程风格，将continue和break去掉了
  */
class ScalaNotBreakContinue {

    val args: Array[String] = Array[String]("aaa","bbb","ccc","ddd","fff")

    def continueBreak(args: Array[String]): Unit = {
        var i = 0
        var foundIt = false
        while (i < args.length && !foundIt) {
            if (!args(i).startsWith("-")) {
                if (args(i).endsWith(".scala"))
                    foundIt = true
            }
            i = i + 1
        }
    }

    // 我们使用 if（于前面 continue 条件相反）去掉了 continue，而重用了 foundIt 布尔变量，去掉了 break。
    // 这段代码和前面 Java 实现非常类似，并且使用了两个 var 变量，使用纯函数化编程的一个方法是去掉 var 变量的使用，
    // 递归函数（回溯函数）的使用是通常使用的一个方法来去除循环结构中使用 var 变量。
    def searchFrom(i: Int): Int =
        if (i >= args.length) -1
        else if (args(i).startsWith("-")) searchFrom(i + 1)
        else if (args(i).endsWith(".scala")) i
        else searchFrom(i + 1)

    val i = searchFrom(0)

    // scala中的break使用，有专门的package
    def useBreak(): Unit = {
        val in = new BufferedReader(new InputStreamReader(System.in))
        breakable {
            while(true) {
                println("? ")
                if(in.readLine()=="") break
            }
        }
    }

}

object ScalaNotBreakContinue {

    def main(args: Array[String]): Unit = {

    }

}
