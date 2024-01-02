package swea.d3.n19113;
import java.util.*;

// 식료품 가게
class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < N * 2; i++) {
                int tmp = sc.nextInt();
                list.add(tmp);
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#" + test_case);
            for (int i = 0; i < N * 2; i++) {
                int tmp = list.get(i);
                //System.out.println(tmp+" "+map.get(tmp));
                if (map.get(tmp) > 0) {
                    map.put(tmp, map.get(tmp) - 1);
                    map.put(tmp + (tmp / 3), map.get(tmp + (tmp / 3)) - 1);
                    sb.append(" " + tmp);
                }
            }
            System.out.println(sb);
        }
    }
}
