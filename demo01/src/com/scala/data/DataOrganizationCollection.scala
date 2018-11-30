package com.scala.data

/**
  * 在Scala中, 集合分为可变集合（mutable）和不可变集合（immutable）
  *
  * 可变集合指的是：长度可变内容可变
  * 不可变集合指的是：长度不可变内容不可变
  *
  * Array： 内容都可变
  *         长度可变数组ArrayBuffer
  *         长度不可变数组Array
  *
  * Seq序列：包含head和tail两部分内容，除了head其他的都是tail（除了头都是尾）
  *
  * 方法的调用与java中的调用规则有些差异
  *
  * List集合
  * Scala 语言的一个设计目标是让程序员可以同时利用面向对象和面向函数的方法编写代码，
  * 因此它提供的集合类分成了可以修改的集合类和不可以修改的集合类两大类型。
  * 比如 Array 总是可以修改内容的，而 List 总是不可以修改内容的。
  *
  * 集合当中常用的方法：
  * 1、map
  * 2、flatten
  * 3、flatMap
  * 4、filter
  * 5、sortBy
  * 6、sortWith
  * 7、foldLeft
  * 8、aggregate（reduceByKey）
  * 9、zip
  * 10、mkString
  * 11、foreach
  *
  * 集合当中了解的方法
  * 1、sorted
  * 2、grouped
  * 3、fold（折叠）
  * 4、foldRight
  * 5、reduce
  * 6、reduceRight
  * 7、reduce
  * 8、reduceLeft
  * 9、union
  * 10、intersect（交集）
  * 11、diff（差集）
  * 12、head（取集合中的头部，只有一个值）
  * 13、tail（取集合中的尾部，除了头部其余的都是尾部）
  * 14、length
  * 15、slice（截取集合，获取子集合）
  * 16、sum
  *
  * Set集合
  * 比如Scala API定义了Set的基Trait类型Set（Trait的概念类似于Java中的Interface，
  * 所不同的 Scala 中的 Trait 可以有方法的实现），分两个包定义 Mutable （可变）和 Immutable （不可变），
  * 使用同样名称的子 Trait。
  *
  *
  */
object DataOrganizationCollection {

    def main(args: Array[String]): Unit = {
        // 一、List集合
        // 可变集合与不可变集合
        // 定义了两个 List 对象 oneTwo 和 threeFour,然后通过:::操作符（其实为:::方法）将两个列表链接起来。
        // 实际上由于 List 的不可以修改特性，Scala 创建了一个新的 List 对象 oneTwoThreeFour 来保存两个列表连接后的值。
        // List 也提供了一个::方法用来向 List 中添加一个元素，
        // ::方法（操作符）是右操作符，也就是使用::右边的对象来调用它的::方法，
        // Scala 中规定所有以：开头的操作符都是右操作符，
        // 因此如果你自己定义以：开头的方法（操作符）也是右操作符。
        val oneTwo = List("1","2")
        val threeFour = List("3","4")
        // 在scala中，所有的：操作符都是右操作符，也就是后面的参数是调用者，而前面的参数是被调用者
        val oneTwoThreeFour = oneTwo ::: threeFour
        println("生成一个新的List对象，原来的List没有变化，List是不可变的")
        // 调用空列表的Nil这个方法
        // 表示Nil创建一个不可变的集合，其中的数据有1,2,3
        val oneTowThree = 1 :: 2 ::3 :: Nil
        // 也就相当于 val oneTowThree =  Nil.::(3).::(2).::(1)
        // list元素是不可变的，不能再次对list做修改
        println(oneTowThree)

        // 二、Set集合
        // 同样调用的apply()方法对Set集合进行初始化的
        // 缺省情况Set为 Immutable Set，如果你需要使用可修改的集合类（ Set 类型），
        // 你可以使用全路径来指明Set，比如 scala.collection.mutalbe.Set。
        var imJetSet = Set[String]("hello", "scala")
        imJetSet += "world"
        // println(imJetSet.contains("scala"))
        imJetSet.foreach(println)

        var muJetSet = scala.collection.mutable.Set[String]("hello","world")
        muJetSet += "scala"
        muJetSet.add("aaaaa")
        muJetSet.foreach(println)

        // 三、Map
        // 不可修改的Map
        val imMap = Map[String, String]("key" -> "value", "key1" -> "value1", "key2" -> "value2")
        println(imMap("key2"))

        // 可修改的Map
        val muMap = scala.collection.mutable.Map[String,String]("key" -> "value", "key1" -> "value1", "key2" -> "value2")
        muMap.update("key", "key->value")
        println(muMap("key"))
    }

}
