package baekjoon.dfs.linked_element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringBuilder sb = new StringBuilder();
    static int[][] Graph;
    static boolean[] visit;
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;
        while (!q.isEmpty()){
            int tmp = q.poll();
            for (int i = 0; i < Graph.length; i++) {
                if(!visit[i] && Graph[tmp][i] == 1){
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노드
        int M = Integer.parseInt(st.nextToken()); // 간선
        Graph = new int[N][N];
        visit = new boolean[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            Graph[A][B] = Graph[B][A] = 1;
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visit[i] && Graph[i][j] == 1){
                    bfs(i);
                    count++;
                }
            }
        }
        // 해당 부분이 함정이었음.
        // 간선이 아예 존재하지 않는 정점의 개수
        for(boolean v : visit){
            if(!v) count++;
        }
        System.out.println(count);

    }
}
