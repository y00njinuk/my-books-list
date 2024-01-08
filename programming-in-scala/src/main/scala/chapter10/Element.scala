package chapter10

import chapter10.Element.elem

abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length

  def above(that: Element): Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    assert(this.width == that1.width)

    elem(this1.contents ++ that1.contents)
  }

  def beside(that: Element): Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height

    elem(
      for(
        (line1, line2) <- this1.contents zip that1.contents
      ) yield line1 + line2
    )
  }

  private def widen(w: Int): Element =
    if(w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right
    } ensuring (w <= _.width)

  private def heighten(h: Int): Element =
    if(h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }

  override def toString: String = contents mkString "\n"
}

object Element {
  private class ArrayElement(val contents: Array[String]) extends Element

  private class LineElement(s: String) extends Element {
    override def width: Int = s.length
    override def height: Int = 1
    override def contents: Array[String] = Array(s)
  }

  private class UniformElement(ch: Char,
                               override val width: Int,
                               override val height: Int) extends Element {
    private val line = ch.toString * width
    override def contents: Array[String] = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element =
    new UniformElement(chr, width, height)

  def elem(line: String): Element =
    new LineElement(line)

  def main(args: Array[String]): Unit = {
    val space = elem(" ")
    val corner = elem("+")

    def spiral(nEdges: Int, direction: Int): Element = {
      if (nEdges == 1)
        elem("+")
      else {
        val sp = spiral(nEdges - 1, (direction + 3) % 4)
        def verticalBar = elem('|', 1, sp.height)
        def horizontalBar = elem('-', sp.width, 1)

        if (direction == 0)
          (corner beside horizontalBar) above (sp beside space)
        else if (direction == 1)
          (sp above space) beside (corner above verticalBar)
        else if (direction == 2)
          (space beside sp) above (horizontalBar beside corner)
        else
          (verticalBar above corner) beside (space above sp)
      }
    }

    val nSides = 6
    println(spiral(nSides, 0))
  }
}