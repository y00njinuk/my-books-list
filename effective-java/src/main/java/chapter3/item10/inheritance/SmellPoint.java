package chapter3.item10.inheritance;

import chapter3.item10.Color;
import chapter3.item10.Point;

// Simple immutable two-dimensional integer point class (Page 37)
public class SmellPoint extends Point {
    public SmellPoint(int x, int y) {
        super(x, y);
    }

    @Override public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;

        if (!(o instanceof SmellPoint))
            return o.equals(this);

        return super.equals(o);
    }

    public static void main(String[] args) {
        SmellPoint sp = new SmellPoint(1, 1);
        ColorPoint cp = new ColorPoint(1, 1, Color.BLUE);

        System.out.println(cp.equals(sp));
    }
}
