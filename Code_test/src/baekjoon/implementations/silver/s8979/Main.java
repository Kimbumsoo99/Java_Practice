package baekjoon.implementations.silver.s8979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

// 올림픽, 8979번, 실버 V
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<int[]> rankList = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            rankList.add(new int[]{num, gold, silver, bronze});
        }

        Collections.sort(rankList, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                if (o1[2] == o2[2]) {
                    if (o1[3] == o2[3]) {
                        return o1[0] - o2[0];
                    }
                    return o2[3] - o1[3];
                }
                return o2[2] - o1[2];
            }
            return o2[1] - o1[1];
        });
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        int pre[] = new int[3];
        for (int i = 0; i < rankList.size(); i++) {
            int current[] = rankList.get(i);
            if (i != 0 && pre[1] == current[1] && pre[2] == current[2] && pre[3] == current[3]) {
                rankMap.put(current[0], rankMap.get(pre[0]));
            } else {
                rankMap.put(current[0], rank);
            }
            rank++;
            pre = rankList.get(i);
        }
        System.out.println(rankMap.get(K));
    }
}
