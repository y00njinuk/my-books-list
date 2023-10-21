package chapter12;

enum Transporatation {
    BUS(100) { int fare(int distance) { return distance*BASIC_FARE; }},
    TRAIN(150) { int fare(int distance) { return distance*BASIC_FARE; }},
    SHIP(150) { int fare(int distance) { return distance*BASIC_FARE; }},
    AIRPLANE(150) { int fare(int distance) { return distance*BASIC_FARE; }};

    protected final int BASIC_FARE;
    Transporatation(int basicFare) { BASIC_FARE = basicFare; }
    public int getBasicFare() { return BASIC_FARE; }
    abstract int fare(int distance);
}

public class EnumEx3 {
}
