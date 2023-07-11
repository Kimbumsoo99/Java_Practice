package baekjoon.dfs.virus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int virus = 0;
    static int[][] Graph;
    static boolean[] visited;
    static void dfs(int current){
        virus++;
        visited[current] = true;
//        System.out.println(current + 1);

        for(int i=0;i<Graph.length;i++){
            if (!visited[i] && Graph[current][i] == 1) {
                dfs(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드의 개수
        int M = Integer.parseInt(br.readLine()); // 간선의 개수
        Graph = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            Graph[A][B] = Graph[B][A] = 1;
        }
        dfs(0);
        System.out.println(virus - 1);
    }
}
