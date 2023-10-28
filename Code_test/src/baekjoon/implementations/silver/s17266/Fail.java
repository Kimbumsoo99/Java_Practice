package baekjoon.implementations.silver.s17266;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 반례
//# 입력
//    4
//    2
//    0 4
//    # 출력
//    3
//    # 정답
//    2
// 이분탐색으로 푸는 문제인듯 하다. 나중에 다시 풀어보자 231029
public class Fail {
    static boolean[] dark;
    static ArrayList<Integer> light = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dark = new boolean[N + 1];
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            light.add(Integer.parseInt(st.nextToken()));
        }
        int answer = 0;
        int count = 0;
        int index = 0;
        int next = light.get(index);
        for (int i = 0; i < N + 1; i++) {
            if (i == next) {
                answer = Math.max(answer, count - answer);
                if (index < M - 1) {
                    index++;
                }
                next = light.get(index);
                count = 0;
            } else {
                count++;
            }
        }
        answer = Math.max(answer, count);
        System.out.println(answer);
    }

}
