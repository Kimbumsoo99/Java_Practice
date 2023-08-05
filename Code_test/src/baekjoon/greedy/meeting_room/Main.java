package baekjoon.greedy.meeting_room;

// 회의실 배정, 1931번, 실버 I
// 그리디 알고리즘 문제(문제 카테고리 보고 깨달음)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] meet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        meet = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meet[i][0] = Integer.parseInt(st.nextToken());
            meet[i][1] = Integer.parseInt(st.nextToken());
            meet[i][2] = meet[i][1] - meet[i][0];
        }

        Arrays.sort(meet, ((o1, o2) -> {
            return o1[0] - o2[0];
        }));
        
        // 문제 풀이중

    }
}
