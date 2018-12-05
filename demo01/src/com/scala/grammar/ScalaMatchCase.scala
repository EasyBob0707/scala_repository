package com.scala.grammar

/**
  * scala中的模式匹配
  * Scala 的 Match 表达式支持从多个选择中选取其一，类似其它语言中的 switch 语句。通常来说，Scala 的 match 表达式支持任意的匹配模式，
  * 这种基本模式将在后面介绍，本篇介绍类似 switch 用法的 match 表达式，也是在多个选项中选择其一。
  */
class ScalaMatchCase {

    // 例如下面的例子从参数中读取食品的名称，然后根据食品的名称，打印出该和该食品搭配的食品，比如输入 ”salt”，与之对应的食品为”pepper”。
    // 如果是”chips”，那么搭配的就是“salsa”等等。
    // 这段代码和 Java 的 switch 相比有几点不同：
    // 一是任何类型的常量都可以用在 case 语句中，而不仅仅是 int 或是枚举类型。
    // 二是每个 case 语句无需使用 break，Scala不支持“fall through”。
    // 三是 Scala 的缺省匹配为”_”,其作用类似 java 中的 default。
    def matchCase(args: Array[String]): Unit = {
        val firstArg = if (args.length > 0 ) args(0) else ""
        firstArg match {
            case "salt" => println("pepper")
            case "chips" => println("salsa")
            case "eggs" => println("bacon")
            case _ => println("huh?")
        }
    }

    // 返回字符串类型数据
    def matchCase01(args: Array[String]): String = {
        val firstArg = if (args.length >0 ) args(0) else ""
        val friend = firstArg match {
            case "salt" => "pepper"
            case "chips" => "salsa"
            case "eggs" => "bacon"
            case _ => "huh?"
        }
        friend
    }
}

object ScalaMatchCase {

    def main(args: Array[String]): Unit = {
        new ScalaMatchCase().matchCase(args)
    }

}
