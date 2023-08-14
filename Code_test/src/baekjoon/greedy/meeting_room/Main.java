package baekjoon.greedy.meeting_room;

// 회의실 배정, 1931번, 실버 I
// 그리디 알고리즘 문제(문제 카테고리 보고 깨달음)
// 해당 문제 풀이는 블로그 참고하였음, 종료 시간 기준으로 정렬

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<int[]> meet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        meet = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] tmp = new int[2];
            tmp[0] = Integer.parseInt(st.nextToken()); // 시작 시간
            tmp[1] = Integer.parseInt(st.nextToken()); // 종료 시간
            meet.add(tmp);
        }

        Collections.sort(meet, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int answer = 0;
        int current = 0;

        for (int[] tmp : meet) {
            if (current <= tmp[0]) {
                answer++;
                current = tmp[1];
            }
        }
        System.out.println(answer);
    }
}
