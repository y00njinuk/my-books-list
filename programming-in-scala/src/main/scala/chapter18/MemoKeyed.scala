package chapter18

class MemoKeyed extends Keyed {
  private var keyCache: Option[Int] = None

  override def computeKey: Int = {
    if(keyCache.isDefined)
      keyCache = Some(super.computeKey)

    keyCache.get
  }
}