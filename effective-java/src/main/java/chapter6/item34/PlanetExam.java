package chapter6.item34;

public class PlanetExam {
    public static void main(String[] args) {
        Planet mars = Planet.MARS;

        System.out.println(mars.mass());
        System.out.println(mars.radius());
        System.out.println(mars.surfaceWeight(mars.mass()));
    }
}
