package com.scala.combination_extends

/**
  * 子类调用父类的构造器，调用父类的主构造器
  *
  * @param s
  */
class LineElement(s:String) extends ArrayElement(Array(s)) {

    override def width = s.length
    override def height = 1

    override def demo(): Unit = {
        println("this is LineElement")
    }

}
