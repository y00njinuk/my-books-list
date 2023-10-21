package chapter12;

class NewClass {
    int newField;
    int getNewField() { return newField; }

    @Deprecated
    int oldField;
    @Deprecated
    int getOldField() { return oldField; }
}

public class AnnotationEx2 {
    public static void main(String[] args) {
        NewClass nc = new NewClass();

        nc.oldField = 10;                       // 'oldField' is deprecated
        System.out.println(nc.getOldField());   // 'getOldField()' is deprecated
    }
}
