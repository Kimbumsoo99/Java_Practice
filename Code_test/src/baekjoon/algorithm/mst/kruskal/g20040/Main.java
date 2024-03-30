package baekjoon.algorithm.mst.kruskal.g20040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        make();
        int answer = 0;
        boolean flag = false;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (!union(find(A), find(B))) {
                if (!flag) {
                    answer = i + 1;
                }
                flag = true;
            }
//            System.out.println(Arrays.toString(parents));
        }
        System.out.println(answer);
    }

    static void make(){
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    static boolean union(int p, int x) {
        if (p == x) {
            return false;
        }
        parents[x] = p;
        return true;
    }
}
