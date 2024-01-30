package chapter18;
public class TimeJavaTest {
    public static void main(String[] args) {
        Time time = new Time();

        time.hour_$eq(1);
        time.minute_$eq(2);

        System.out.println(time.hour());
        System.out.println(time.minute());
    }
}
