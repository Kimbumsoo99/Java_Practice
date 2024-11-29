package baekjoon.graph.bfs.g1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder answerBuilder = new StringBuilder();
    static ArrayList<ArrayList<Integer>> Graph;
    static String answer = "YES";
    static boolean[] visited, ox;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            answer = "YES";
            int V = Integer.parseInt(st.nextToken()); // 정점
            int E = Integer.parseInt(st.nextToken()); // 간선
            Graph = new ArrayList<>();
            for (int j = 0; j < V + 1; j++) {
                Graph.add(new ArrayList<>());
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                Graph.get(u).add(v);
                Graph.get(v).add(u);
            }
            visited = new boolean[V + 1];
            ox = new boolean[V + 1];

            for (int j = 1; j < V + 1; j++) {
                if (!visited[j]) {
                    if (!bfs(j)) {
                        break;
                    }
                }
            }
            answerBuilder.append(answer).append("\n");
        }
        System.out.println(answerBuilder.toString());
    }

    private static boolean bfs(int idx) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        dq.offer(idx);
        visited[idx] = true;
        ox[idx] = true;

        while (!dq.isEmpty()) {
            int tmp = dq.poll();
//            System.out.println(tmp + " " + ox[tmp]);
            for (Integer next : Graph.get(tmp)) {
                if (!visited[next]) {
                    ox[next] = !ox[tmp];
                    visited[next] = true;
                    dq.offer(next);
                } else if (ox[next] == ox[tmp]) {
                    answer = "NO";
                    return false;
                }
            }

        }

        return true;
    }
}