package com.scala.data

/**
  * 数组的数据结构
  */
object DataOrganizationArray {

    def main(args: Array[String]): Unit = {
        /**
          * 数组用val修饰, 表示数组的长度是不变的
          * 数组的元素的是可变的
          */
        val arr = Array(1,3,4,6,7,9,65,43,21,45)

        println("============================MAP==========================")

        /**
          * 1、数组的方法之一： map
          * map方法中传入一个函数
          */
        val fx = (num: Int) => num * 100
        val arrs = arr.map(fx)
        // 将函数的定义直接传入方法中作参数 arr.map((num: Int) => num * 100)
        // 将函数的类型去掉，让函数自己推测类型 arr.map(num => num * 100)
        // 将函数中的参数去掉，用_下划线替代每一个参数 arr.map(_ * 100)
        println("经过数据的MAP处理过的数据")
        arrs.foreach((n: Int) => print(n + " "))
        println()
        println("源数组中的数据")
        arr.foreach((i: Int) => print(i + " "))

        println()

        println("============================FLATTEN==========================")

        /**
          * 1、数组的方法之二： flatten 扁平化操作
          * 初始化数组： val strs = Array("hello Tom hello Amy", "hello DaMing hello LingLing")
          * 经过map的运算： val strs = Array(Array("hello", "Tom", "hello", "Amy"), Array("hello", "DaMing", "hello", "LingLing"))
          * 最后调用flatten： val strs = Array("hello", "Tom", "hello", "Amy", "hello", "DaMing", "hello", "LingLing")
          *
          *
          * 同样以上的结果可以一次性搞定
          */
        val strs = Array("hello Tom hello Amy", "hello DaMing hello LingLing")
        // 下划线相当于数组中的每一个元素，由于数组元素的类型是String，因此可以调用String的split()方法
        val mapStrs = strs.map(_.split(" "))
        println(mapStrs.foreach(println(_)))
        val flattenStr = mapStrs.flatten
        flattenStr.foreach(println(_))

        strs.map(_.split(" ")).flatten.foreach((y: String) => println(y))

        strs.map((str: String) => str.split(" ")).flatten.foreach(println(_))

        // flatMap表示的含义为：先Map后Flatten, 将两个操作合二为一的操作
        // 注意： 在连续一系列的操作当中，下划线(_)只能使用一次，因为你在使用的时候
        // scala已经将推测出下划线(_)的类型，将下划线(_)再次使用会出现类型不匹配的问题
        strs.flatMap(_.split(" ")).foreach((x: String) => println(x))

        strs.flatMap((str: String) => str.split(" ")).foreach(println(_))
    }

}
