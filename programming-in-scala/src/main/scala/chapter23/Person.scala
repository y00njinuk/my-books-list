package chapter23

import scala.collection.WithFilter

case class Person(name: String,
                  isMale: Boolean,
                  children: Person*)

object Person {
  def main(args: Array[String]): Unit = {
    val lara = Person("Lara", false)
    val bob = Person("Bob", true)
    val juile = Person("Juile", false, lara, bob)

    val persons = List(lara, bob, juile)

    val res: WithFilter[Person, List] = persons.withFilter(p => !p.isMale)

    val res1 =
      persons
        .withFilter(p => !p.isMale)
        .flatMap((p: Person) => p.children.map(c => (p.name, c.name)))

    val res2 =
      for(p <- persons; if !p.isMale; c <- p.children) yield (p.name, c.name)

    println(res1)
    println(res2)
  }
}
