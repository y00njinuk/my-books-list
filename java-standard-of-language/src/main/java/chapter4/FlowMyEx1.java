package chapter4;

public class FlowMyEx1 {
    static void exampleOfSwitch(String animal) {
        switch (animal) {
            case "DOG":
                System.out.println("domestic animal");
                break;
            case "CAT":
                System.out.println("domestic animal");
                break;
            case "TIGER":
                System.out.println("wild animal");
                break;
            default:
                System.out.println("unknown animal");
                break;
        }
    }

    public static void main(String[] args) {;
        exampleOfSwitch("DOG");
    }
}
