package chapter13

import chapter13.bobsdelights.{Fruits, showFruit}

object PrintMenu {
  def main(args: Array[String]): Unit = {
    for (fruit <- Fruits.menu)
      showFruit(fruit)
  }
}