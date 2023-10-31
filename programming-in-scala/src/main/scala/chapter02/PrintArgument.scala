package chapter02

class PrintArgument {
  // 명령형 스타일
  def printArgs1(args: Array[String]): Unit = {
    var i = 0;
    while (i < args.length) {
      println(args(i))
      i += 1
    }
  }

  // 함수형 스타일
  def printArgs2(args: Array[String]): Unit = for (arg <- args) println(arg)

  // 좀 더 개선된 함수형 스타일
  def printArgs3(args: Array[String]): Unit = args.foreach(println)
}
