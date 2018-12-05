package com.scala.grammar

import scala.io.{BufferedSource, Source}

/**
  * 成员函数
  * 当程序越来越大，你需要将代码细化为小的容易管理的模块。
  * Scala 支持多种方法来细化程序代码，这些方法也为有经验的程序员已经掌握的：使用函数，和 Java 相比，
  * Scala 提供了多种 Java 不支持的方法来定义函数，除了类成员函数外，Scala 还支持嵌套函数，函数字面量，函数变量等。
  */
class MemberFunction {



}

object MemberFunction {

    def main(args: Array[String]): Unit = {
        // 成员函数 processFile 使用两个参数，一个文件名，一个为字符长度，其作用是打印出文件中超过指定字符长度的所有行。
        // 它调用另外一个私有成员函数 processLine 完成实际的操作。
        MemberFunction.processFile(args(0),args(1).toInt)
    }

    def processFile(filename: String, width: Int) {
        val source: BufferedSource = Source.fromFile(filename)
        for (line <- source.getLines())
            processLine(filename,width,line)
    }

    // 私有方法
    private def processLine(filename:String, width:Int, line:String){
        if(line.length > width)
            println(filename + ":" +line.trim)
    }

    // 在函数的内部再定义函数，如同定义一个局部变量
    def innerProcessFile(filename: String, width: Int) {
        def processLine(filename:String,
                        width:Int, line:String){
            if(line.length > width)
                println(filename + ":" +line.trim)
        }
        val source= Source.fromFile(filename)
        for (line <- source.getLines())
            processLine(filename,width,line)
    }

    // 这个例子不私有成员函数 processLine 移动到 processFile 内部，成为一个局部函数，
    // 也正因为 processLine 变成了 processFile 的一个局部函数，因此 processLine 可以直接访问到 processFile 的参数 filename 和 width
    def innerProcessFile02(filename: String, width: Int) {
        def processLine(line:String){
            if(line.length > width)
                println(filename + ":" +line.trim)
        }
        val source= Source.fromFile(filename)
        for (line <- source.getLines())
            processLine(line)
    }

}
