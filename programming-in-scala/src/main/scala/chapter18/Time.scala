package chapter18

/**
  public class chapter18.Time {
    public static void main(java.lang.String[]);
    public int hour();
    public void hour_$eq(int);
    public int minute();
    public void minute_$eq(int);
    public chapter18.Time();
  }
 */
class Time {
  var hour = 12
  var minute = 0
}

object Time {
  def main(args: Array[String]): Unit = {
    val time = new Time

    time.hour = 1     // hour_$eq(1)
    time.minute = 10  // minute_$eq(10)
  }
}
