package chapter5.item30.compareFruits.problem1;

public class Apple implements Fruit, Comparable<Apple> {
    private final Integer size;

    public Apple(Integer size) {
        this.size = size;
    }

    @Override // duplicate
    public Integer getSize() {
        return size;
    }

    @Override // duplicate
    public int compareTo(Apple other) {
        return size.compareTo(other.size);
    }
}
