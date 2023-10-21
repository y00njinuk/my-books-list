package chapter6.item34;

public class AppleExam {
    public static void main(String[] args) {
        Apple fuji = Apple.FUJI;
        Apple fuji_two = Apple.FUJI;
        Apple pippin = Apple.PIPPIN;

        System.out.println(fuji.hashCode() == fuji_two.hashCode()); // true
        System.out.println(fuji.hashCode() == pippin.hashCode());   // false

        System.out.println(fuji);       // Apple@634
        System.out.println(fuji_two);   // Apple@634
        System.out.println(pippin);     // Apple@635
    }
}
