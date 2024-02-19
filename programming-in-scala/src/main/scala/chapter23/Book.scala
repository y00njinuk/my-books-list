package chapter23

case class Book(title: String, authors: String*)

object Book {
  def main(args: Array[String]): Unit = {
    val books = List(
      Book(
        "Structure and Interpretation of Computer Programs",
        "Abelson, Harold", "Sussman, Gerald J."
      ),
      Book(
        "Principles of Compiler Design",
        "Aho, Alfred", "Ullman, Jeffrey"
      ),
      Book(
        "Programming in Modula-2",
        "Wirth, Niklaus"
      ),
      Book(
        "Elements of ML Programming",
        "Ullman, Jeffrey"
      ),
      Book(
        "The Java Language Specification",
        "Gosling, James", "Joy Bill", "Steele, Guy", "Bracha, Gilad"
      )
    )

    println(for (b: Book <- books; a <- b.authors) yield (b.title, a))

    val res = for (b <- books; a <- b.authors if a startsWith "Gosling") yield b.title
    println(res)

    val res2 = for(b <- books if (b.title indexOf "Program") >= 0) yield b.title
    println(res2)

    val res3 = for(b1 <- books; b2 <- books if b1 != b2;
                   a1 <- b1.authors; a2 <- b2.authors if a1 == a2) yield a1
    println(res3)

    def removeDuplicates[A](xs: List[A]): List[A] = {
      if (xs.isEmpty) xs
      else
        // for(x <- xs.tail if x != xs.head) yield x
        xs.head :: removeDuplicates(xs.tail filter (x => x != xs.head))
    }
  }
}
