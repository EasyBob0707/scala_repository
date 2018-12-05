package com.scala.combination_extends

/**
  * 在Scala中，用final修饰的类不能被继承，用final修饰的成员不能被重载
  *
  * @param ch
  * @param width
  * @param height
  */
class UniformElement(ch: Char, override val width: Int, override val height: Int) extends Element {

    private val line = ch.toString * width
    def contents = Array.fill(height)(line)

    def invokeDemo(e: Element) {
        e.demo()
    }

}

object UniformElement {

    def main(args: Array[String]): Unit = {

        val e1: Element = new ArrayElement(Array("hello", "world"))

        val ae: ArrayElement = new LineElement("hello")
        val e2: Element = ae
        /*val e3: Element = */new UniformElement('x', 2, 3).invokeDemo(e2)
    }

}
