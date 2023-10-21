package chapter3.item13;

public class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public static Person copyPerson(Person person) {
        return new Person(person.name);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person("Test");
        Person clone_person = Person.copyPerson(person);
    }
}
