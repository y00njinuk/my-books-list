package chapter5.item30.compareFruits.problem1;

public class Orange implements Fruit, Comparable<Orange> {
    private final Integer size;

    public Orange(Integer size) {
        this.size = size;
    }

    @Override // duplicate
    public Integer getSize() {
        return size;
    }

    @Override // duplicate
    public int compareTo(Orange other) {
        return size.compareTo(other.size);
    }
}
