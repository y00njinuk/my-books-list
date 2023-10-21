package chapter5.item30.compareFruits.problem3;

public class Fruit<T> implements Comparable<T> {
    private final Integer size;

    public Fruit(Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    @Override
    public int compareTo(T other) {
        return 0;
//        return size.compareTo(other.getSize()); // Error.
    }
}
