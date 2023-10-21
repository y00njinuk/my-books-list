package chapter3.item13;

public class KoreaPerson extends Person implements Cloneable {
    String hometown;

    public KoreaPerson(String name, String hometown) {
        super(name);
        this.hometown = hometown;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (KoreaPerson) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        KoreaPerson koreaPerson = new KoreaPerson("Test", "Seoul");
        KoreaPerson clone_koreaPerson = (KoreaPerson) koreaPerson.clone();
    }
}
