package chapter18

class Keyed {
  def computeKey = {
    Thread.sleep(10000) // 10 secs
    123
  }
}