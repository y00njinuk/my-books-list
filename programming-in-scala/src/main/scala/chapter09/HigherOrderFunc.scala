package chapter09

object HigherOrderFunc {
  def containsNeg(nums: List[Int]): Boolean = {
    var exists = false
    for(num <- nums)
      if(num < 0)
        exists = true
    exists
  }

  def containNegImproved(nums: List[Int]): Boolean = {
    nums.exists(_ < 0)
  }

  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4)

    containsNeg(list)
    containNegImproved(list)
  }
}
