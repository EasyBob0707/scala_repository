package com.scala.grammar

import java.io.{File, PrintWriter}

/**
  * Scala中新的控制结构
  *
  */
class ScalaControllerConstruction {

    // op函数进行嵌套使用
    def twice(op: Double => Double, x: Double) = op(op(op(x)))

    def withPrintWriter (file: File, op: PrintWriter => Unit) {
        val writer=new PrintWriter(file)
        try{
            op(writer)
        }finally{
            writer.close()
        }
    }

}

object ScalaControllerConstruction {

    def main(args: Array[String]): Unit = {
        // 下划线表示x的值，每次调用函数返回一个新的x的值，调用次数要看函数的嵌套层数
        // 下划线可以指代一个参数或者多个参数
        println(new ScalaControllerConstruction().twice(_ + 1, 5))


        println{"一个参数的方法可以将小括号替换成大括号!"}
    }

}
