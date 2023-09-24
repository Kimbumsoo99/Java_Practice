package baekjoon.implementations.silver.s1713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

//    static ArrayList<int[]> list = new ArrayList<>(); // 숫자, count, last
    static HashMap<Integer, Integer> goodCount = new HashMap<>();
    static HashMap<Integer, Integer> goodLast = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int recommend = Integer.parseInt(st.nextToken());
            if (goodCount.size() < size || goodCount.containsKey(recommend)) {
                goodCount.put(recommend, goodCount.getOrDefault(recommend, 0) + 1);
                if (!goodLast.containsKey(recommend)) {
                    goodLast.put(recommend, i);
                }
            } else { // 게시판 사진을 삭제해야 하는 경우
                int x = removeFind();
                if (x != recommend) {
                    goodCount.remove(x);
                    goodLast.remove(x);
                    goodCount.put(recommend, 1);
                    goodLast.put(recommend, i);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = goodCount.keySet().iterator();
        ArrayList<Integer> tmp = new ArrayList<>();
        while (it.hasNext()) {
            tmp.add(it.next());
        }
        Collections.sort(tmp);
        for (Integer value : tmp) {
            sb.append(value).append(" ");
        }
        System.out.println(sb);
    }

    static int removeFind() {
        ArrayList<int[]> list = new ArrayList<>();
        Iterator<Integer> it = goodCount.keySet().iterator();
        while (it.hasNext()) {
            int tmp = it.next();
            list.add(new int[]{tmp, goodCount.get(tmp), goodLast.get(tmp)});
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[2] - o2[2];
            }
            return o1[1] - o2[1];
        });
        return list.get(0)[0];
    }
}
