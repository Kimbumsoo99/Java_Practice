package baekjoon.dfs.dfs_bfs_impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static int[][] Graph;
    public static boolean[] marker;
    static StringBuilder dfsSb = new StringBuilder();
    static StringBuilder bfsSb = new StringBuilder();
    public static void dfs(int currentNode){
        dfsSb.append(currentNode+1).append(" ");
        marker[currentNode] = true;
        for(int i=0;i< Graph.length;i++){
            if(!marker[i] && Graph[currentNode][i] == 1){
                dfs(i);
            }
        }
    }

    /**
     * Stack을 통한 DFS 구현은 맞으나, 문제에서 요구하는 요구사항인 숫자가 작은 순서대로 해야하는 요구사항에는 어울리지 않는다.
     * @param currentNode
     */
    public static void dfsStack(int currentNode){
        Stack<Integer> stack = new Stack<>();
        stack.push(currentNode);
        marker[currentNode] = true;
        while (stack.size() > 0) {
            int current = stack.pop();
            dfsSb.append(current + 1).append(" ");
            for(int i=0;i< Graph.length;i++){
                if (!marker[i] && Graph[current][i] == 1) {
                    marker[i] = true;
                    stack.push(i);
                    break;
                }
            }
        }
    }
    public static void bfs(int currentNode){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offerLast(currentNode);
        marker[currentNode] = true;
        while (queue.size() > 0) {
            int current = queue.removeFirst();
            bfsSb.append(current+1).append(" ");
            for(int i=0;i<Graph.length;i++){
                if (!marker[i] && Graph[current][i] == 1) {
                    marker[i] = true;
                    queue.offerLast(i);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점
        int M = Integer.parseInt(st.nextToken()); // 간선
        int V = Integer.parseInt(st.nextToken());

        Graph = new int[N][N];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            Graph[A-1][B-1] = Graph[B-1][A-1] = 1;
        }
        marker = new boolean[N];
//        dfs(V-1);
        dfsStack(V-1);
        marker = new boolean[N];
        bfs(V-1);
        System.out.println(dfsSb);
        System.out.println(bfsSb);
    }

}
