package chapter7;

interface Repariable {}

class Unit {
    int hitPoint;
    final int MAX_HP;
    Unit(int hp) {
        MAX_HP = hp;
    }
}

class GroundUnit extends Unit {
    GroundUnit(int hp) {
        super(hp);
    }
}

class AirUnit extends Unit {
    AirUnit(int hp) {
        super(hp);
    }
}

class Tank extends GroundUnit implements Repariable {
    boolean sizmode = false;

    Tank() {
        super(150);
        hitPoint = MAX_HP;
    }

    public void on() {
        this.sizmode = true;
    }
    public void off() {
        this.sizmode = false;
    }

    public String toString() {
        return "Tank";
    }
}

class Dropship extends AirUnit implements Repariable {
    Dropship() {
        super(125);
        hitPoint = MAX_HP;
    }
    public String toString() {
        return "Dropship";
    }
}

class Marine extends GroundUnit {
    Marine() {
        super(40);
        hitPoint = MAX_HP;
    }
}

class SCV extends GroundUnit implements Repariable {
    SCV() {
        super(60);
    }

    void repair(Repariable r) {
        if(r instanceof Unit) {
            Unit u = (Unit) r;
            while(u.hitPoint != u.MAX_HP) {
                u.hitPoint++;
            }
            System.out.println(u + " 의 수리가 끝났습니다.");
        }
    }
}


public class RepairableTest {
    public static void main(String[] args) {
        Tank tank = new Tank();
        Dropship dropship = new Dropship();

        Marine marine = new Marine();
        SCV scv = new SCV();

        scv.repair(tank);
        scv.repair(dropship);
//        scv.repair(marine);   // compile error.
    }
}
