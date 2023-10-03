package baekjoon.implementations.silver.rank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class MainFail {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int player = Integer.parseInt(st.nextToken());
        if (N == 0) {
            System.out.println(1);
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            list.add(tmp);
        }
        Collections.sort(list, Collections.reverseOrder());
        for (int i = player; i < list.size(); i++) {
            list.remove(player);
        }
        if (list.size() == player && list.get(list.size() - 1) >= score) {
            System.out.println(-1);
            return;
        }
        // 랭킹 정보
        int rank = 0;
        int count = 1;
        int pre = Integer.MIN_VALUE;
        for (Integer next : list) {
            System.out.println(next);
            if (pre != next) {
                rank += count;
                count = 1;
            }else{
                count++;
            }

            if (score >= next) {
                break;
            }
            pre = next;
        }
        System.out.println(rank);
    }
}
