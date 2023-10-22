package baekjoon.dfs.g1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

// 최단경로, 골드 IV
public class Fail {
    static int[][] Graph;
    static boolean[] visit;
    static int[] answer;
    static int V;
    static int E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        Graph = new int[V][V];
        answer = new int[V];
        int start = Integer.parseInt(br.readLine()) - 1;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int W = Integer.parseInt(st.nextToken());
            Graph[A][B] = W;
        }
        for (int i = 0; i < V; i++) {
            bfs(start, i);
        }
        for (int i = 0; i < V; i++) {
            if (answer[i] == -1) {
                System.out.println("INF");
            } else {
                System.out.println(answer[i]);
            }
        }
    }
    private static void dfs(int start, int finish) {
        if (start == finish) {
            answer[start] = 0;
            return;
        }
        int value = Integer.MAX_VALUE;
        visit = new boolean[V];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{start, 0});
        visit[start] = true;
        while (!stack.isEmpty()) {
            int tmp[] = stack.pop();
            for (int i = 0; i < V; i++) {
                if (i == tmp[0]) {
                    continue;
                }
                if (!visit[i] && Graph[tmp[0]][i] != 0) {
                    stack.push(new int[]{i, tmp[1] + Graph[tmp[0]][i]});
                    visit[i] = true;
                } else if (visit[i]) {

                }
            }
        }
    }

    private static void bfs(int start, int finish) {
        if (start == finish) {
            answer[start] = 0;
            return;
        }
        int value = Integer.MAX_VALUE;
        visit = new boolean[V];
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{start, 0});
        visit[start] = true;
        while (!dq.isEmpty()) {
            int tmp[] = dq.pollFirst();
            for (int i = 0; i < V; i++) {
                if (!visit[i] && Graph[tmp[0]][i] != 0) {
                    if (i == finish) {
                        value = Math.min(value, tmp[1] + Graph[start][i]);
                        break;
                    }
                    visit[i] = true;
                    dq.offer(new int[]{i, tmp[1] + Graph[start][i]});
                }
            }
        }
        if (!visit[finish]) {
            answer[finish] = -1;
        } else {
            answer[finish] = value;
        }
    }
}
