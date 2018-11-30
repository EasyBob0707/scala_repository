package com.scala.data

/**
  * scala中的元组
  *
  * 元组与集合的区别：
  * 元组可以包含不同的数据类型，但是集合只能包含相同的数据类型，元组是由长度限制的目前scala只支持到22个，可以自己再进行扩充
  *
  * 定义：
  * val 变量名称 = (元素...)
  *
  * 用途：
  * 在方法的返回数据中，可以包含返回多个不同类型的数据
  *
  * 元组中数据的访问方式：
  * 元组名称._x(x表示索引，与数组不同的是元组的索引是从1开始的)
  */
object DateOrganizationTuples {

    def main(args: Array[String]): Unit = {
        // 初始化元组中有5个元素
        val tuples = (1,2,3,"hello","scala")
        // 访问第一个参数
        println(tuples._1)
    }

}
