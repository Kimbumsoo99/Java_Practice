import java.util.ArrayList;
import java.util.Collections;

class Main
{
    public static void main(String args[]) throws Exception
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(3);
        Collections.sort(list,(o1, o2) -> {
            System.out.println(o1 + " " + o2 + " " + (o1 - o2));
            return o1 - o2;
        });
        System.out.println(list.get(0));
        System.out.println("Donghyuk".compareTo("ss"));
    }
}