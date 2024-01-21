package test;

public class BusTest {

    public static void main(String[] args) {
        Bus b = new Bus();
        Bus c = new Bus();
        System.out.println(b.hashCode() == b.hashCode() + 1);
        System.out.println(c.add(2, 3) + " " + 1);
        System.out.println(c.add(2L, 3));
        Bus.overRun();
        c.overRun();

    }
}
