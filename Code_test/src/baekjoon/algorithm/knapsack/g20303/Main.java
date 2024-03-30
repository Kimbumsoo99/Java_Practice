package baekjoon.algorithm.knapsack.g20303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Child{
    int group, value;

    public Child(int group, int value) {
        this.group = group;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Child{" +
                "group=" + group +
                ", value=" + value +
                '}';
    }
}
public class Main {
    static int dp[][], N, M, K, parents[], cost[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cost = new int[N + 1];
        make();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i+1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int p = Math.min(A, B);
            int x = Math.max(A, B);
            unionSet(findSet(p), findSet(x));
        }
        Child[] C = new Child[N + 1];
        for (int i = 1; i < N + 1; i++) {
            if (C[findSet(i)] == null) {
                C[findSet(i)] = new Child(1, cost[i]);
            } else {
                C[findSet(i)].group++;
                C[findSet(i)].value += cost[i];
            }
        }
//        System.out.println(Arrays.toString(C));
        dp = new int[N + 1][K + 1]; // 아이들의 수, 최대 명수
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < K + 1; j++) {
                if (C[i] == null) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    if (j > C[i].group) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - C[i].group] + C[i].value);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
//        for (int i = 0; i < N+1; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.println(dp[N][K]);
    }

    static void make(){
        parents = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int x) {
        if (parents[x] == x) return x;
        return parents[x] = findSet(parents[x]);
    }

    static boolean unionSet(int p, int x) {
        if (p == x) return false;
        parents[x] = p;
        return true;
    }
}
