package chapter5.item30.compareFruits.problem2;

public class Fruit implements Comparable<Fruit> {
    private final Integer size;

    public Fruit(Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    @Override
    public int compareTo(Fruit other) {
        return size.compareTo(other.getSize());
    }
}
