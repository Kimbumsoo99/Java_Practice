package baekjoon.algorithm.mst.prim.g21924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 크루스칼로 해보기
public class Kruskal {
    static ArrayList<int[]> edgeList = new ArrayList<>();
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parents[i] = i;
        }
        int M = Integer.parseInt(st.nextToken());
        long maxWeight = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edgeList.add(new int[]{A, B, C});
            maxWeight += C;
        }
        Collections.sort(edgeList, (o1, o2) -> o1[2] - o2[2]);
        int cnt = 0;
        long weight = 0;
        for (int i = 0; i < M; i++) {
            int[] cur = edgeList.get(i);
            if (union(find(cur[0]), find(cur[1]))) {
                weight += cur[2];
                if (++cnt == N - 1) {
                    break;
                }
            }
        }
        System.out.println(cnt == N - 1 ? maxWeight - weight : -1);
    }

    static boolean union(int p, int x) {
        if(p==x) return false;
        parents[x] = p;
        return true;
    }

    static int find(int x) {
        if(x==parents[x]) return x;
        return parents[x] = find(parents[x]);
    }
}
