package chapter12;

enum Direction { EAST(1), SOUTH(2), WEST(3), NORTH(4);
    // define variable.

    Direction(int i) {
        // implemented code.
    }
}

public class EnumEx1 {
    public static void main(String[] args) {
        Direction d1 = Direction.EAST;
        Direction d2 = Direction.valueOf("WEST");
        Direction d3 = Enum.valueOf(Direction.class, "NORTH");

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);

        switch(d1) {
            case EAST: System.out.println("EAST"); break;
            case SOUTH: System.out.println("SOUTH"); break;
            case WEST: System.out.println("WEST"); break;
            case NORTH: System.out.println("NORTH"); break;
            default: System.out.println("Invalid"); break;
        }

        Direction[] dArr = Direction.values();

        for(Direction d: dArr)
            System.out.printf("%s=%d\n", d.name(), d.ordinal());
    }
}
