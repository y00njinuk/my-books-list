package chapter26

object Domain {
//  def apply(parts: String*): String = parts.reverse.mkString(".")
  def unapply(whole: String): Option[Seq[String]] = Some(whole.split("\\.").reverse)
}
