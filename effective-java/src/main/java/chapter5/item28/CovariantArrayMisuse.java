package chapter5.item28;

public class CovariantArrayMisuse {
    public static void main(String[] args) {
        Object[] objectArray = new Long[1];
        objectArray[0] = "타입이 달라 넣을 수 없다"; // ArrayStoreException
    }
}
