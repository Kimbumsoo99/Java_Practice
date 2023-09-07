package baekjoon.implementations.silver.s2910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 2910번, 실버 III, 빈도 정렬 문제
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> priority = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (!map.containsKey(tmp)) {
                priority.put(tmp, i);
            }
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            list.add(it.next());
        }
//        Collections.sort(list, ((o1, o2) -> {
//            if (map.get(o1) == map.get(o2)) {
//                return priority.get(o1) - priority.get(o2);
//            }
//            return map.get(o2) - map.get(o1);
//        }));
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.get(o1) == map.get(o2)) {
                    return priority.get(o1) - priority.get(o2);
                }
                else{
                    return map.get(o2) - map.get(o1);
                }
            }});
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            int loop = map.get(list.get(i));
            for (int j = 0; j < loop; j++) {
                sb.append(list.get(i)).append(" ");
            }
        }
        System.out.println(sb);
    }
}
