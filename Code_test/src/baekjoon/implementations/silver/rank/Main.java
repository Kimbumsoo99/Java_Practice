package baekjoon.implementations.silver.rank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
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
        ArrayList<Integer> rank = new ArrayList<>();
        if (list.size() > player) {
            for (int i = 0; i < player; i++) {
                rank.add(list.get(i));
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                rank.add(list.get(i));
            }
        }

        int size = 0;
        int playerRank = 1;
        int count = 0;
        for (Integer pScore : rank) {
            if (pScore > score) { // 사용자 점수보다 더 큰 경우, 당연히 증가.
                playerRank++;
                count = 0;
            } else if (pScore < score) {
                System.out.println(playerRank - count);
                return;
            } else {
                playerRank++;
                count++;
            }
        }
        if (rank.size() < player) {
            System.out.println(playerRank - count);
        } else {
            System.out.println(-1);
        }
    }
}
