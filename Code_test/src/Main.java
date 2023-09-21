import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("12.4", 1);
        map.put("2.1", 2);
        System.out.println(map.get("12.4") + " " + map.containsKey("2.1"));
    }
}