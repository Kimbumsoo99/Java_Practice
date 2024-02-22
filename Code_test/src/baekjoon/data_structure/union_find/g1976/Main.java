package baekjoon.data_structure.union_find.g1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parents = new int[N];
        M = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        make();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    union(findSet(i), findSet(j));
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int pre = findSet(Integer.parseInt(st.nextToken()) - 1);
        for (int i = 1; i < M; i++) {
            if (pre != findSet(Integer.parseInt(st.nextToken()) - 1)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    static void make() {
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int x) {
        if (x == parents[x])
            return x;
        return parents[x] = findSet(parents[x]);
    }

    static boolean union(int p, int x) {
        if (p == x)
            return false;
        parents[x] = p;
        return true;
    }
}
