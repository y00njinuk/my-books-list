package chapter6.item38;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static chapter6.item38.ExtendedOperation.test;

public class OperationExam {
    // Using a collection instance to represent a collection of extended enums (page 178)
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);

        List<Operation> resultList = new ArrayList<>(AddedOperation.values().length + ExtendedOperation.values().length);
        Collections.addAll(resultList, AddedOperation.values());
        Collections.addAll(resultList, ExtendedOperation.values());

        test(resultList, x, y);
    }
}
