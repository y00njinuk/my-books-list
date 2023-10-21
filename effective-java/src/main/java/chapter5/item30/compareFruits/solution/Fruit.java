package chapter5.item30.compareFruits.solution;

public class Fruit<T extends Fruit<T>> implements Comparable<T> {
    private final Integer size;

    public Fruit(Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    @Override
    public int compareTo(T other) {
        return size.compareTo(other.getSize());
    }
}
