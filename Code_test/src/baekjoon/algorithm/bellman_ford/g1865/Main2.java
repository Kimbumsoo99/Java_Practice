package baekjoon.algorithm.bellman_ford.g1865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    static ArrayList<int[]>[] Graph;
    static int[] distance;
    static final int INF = 1_000_000_000;
    static int N, M, W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int test_case = 1; test_case < T + 1; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            distance = new int[N + 1];
            Graph = new ArrayList[N + 1];
            for (int i = 0; i < N + 1; i++) {
                Graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) { // 도로 정보
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());

                Graph[A].add(new int[] { B, C });
                Graph[B].add(new int[] { A, C });
            }
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                Graph[A].add(new int[] { B, -C });
            }

            boolean isMinusCycle = false; // 음의 사이클 확인
            for (int i = 1; i <= N; i++) {
                if (bell(i)) { // 벨만 포드 결과 음의 사이클 발동
                    isMinusCycle = true;
                    break;
                }
            }
            if (isMinusCycle) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean bell(int start) {
        Arrays.fill(distance, INF);
        distance[start] = 0;
        boolean update = false;

        // (정점 - 1)번 동안 최단거리 초기화
        for (int i = 1; i < N; i++) {
            update = false;

            // 최단 거리 초기화
            for (int j = 1; j <= N; j++) {
                for (int[] next : Graph[j]) {
                    if (distance[j] != INF && distance[next[0]] > distance[j] + next[1]) {
                        distance[next[0]] = distance[j] + next[1];
                        update = true;
                    }
                }
            }
            // 최단 거리 초기화가 일어나지 않은 경우 반복문 종료
            if (!update) {
                break;
            }
        }

        // 끝까지 업데이트가 발생한 경우
        // 마지막 한 번(정점의 개수)도 업데이트가 발생하면 음수 사이클
        if (update) {
            for (int j = 1; j <= N; j++) {
                for (int[] next : Graph[j]) {
                    if (distance[j] != INF && distance[next[0]] > distance[j] + next[1]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
