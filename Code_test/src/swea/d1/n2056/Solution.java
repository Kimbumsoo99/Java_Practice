package swea.d1.n2056;
import java.util.*;
import java.io.FileInputStream;

class Solution {
// 2056. 연월일 달력
    public static void main(String args[]) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(1, 31);
            map.put(2, 28);
            map.put(3, 31);
            map.put(4, 30);
            map.put(5, 31);
            map.put(6, 30);
            map.put(7, 31);
            map.put(8, 31);
            map.put(9, 30);
            map.put(10, 31);
            map.put(11, 30);
            map.put(12, 31);

            int T;
            T = sc.nextInt();
            for (int test_case = 1; test_case <= T; test_case++) {
                String day = sc.next();
                String yy = day.substring(0, 4);
                String mm = day.substring(4, 6);
                String dd = day.substring(6);
                int im = Integer.parseInt(mm);
                int id = Integer.parseInt(dd);
                if (!map.containsKey(im) || id > map.get(im)) {
                    System.out.println("#" + test_case + " " + -1);
                } else {
                    System.out.println("#" + test_case + " " + yy + "/" + mm + "/" + dd);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
