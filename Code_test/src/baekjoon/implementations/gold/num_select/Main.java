package baekjoon.implementations.gold.num_select;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] Graph;
    static HashSet<Integer> answer = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine()) - 1;
            Graph[i][tmp] = 1;
        }

        for (int i = 0; i < N; i++) {
            dfs(i);
        }
        System.out.println(answer.size());
        List<Integer> list = new ArrayList<Integer>(answer);
        Collections.sort(list);
        for(Integer i : list){
            System.out.println(i);
        }
    }

    static void dfs(int start){
        Stack<Integer> stack = new Stack<>();
        boolean[] visit = new boolean[Graph.length];
        visit[start] = true;
        stack.push(start);
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            for (int i = 0; i < Graph.length; i++) {
                if (!visit[i] && Graph[tmp][i] == 1) {
                    stack.push(i);
                    visit[i] = true;
                }
                if (Graph[tmp][i] == 1 && i == start) {

                }
            }
        }
    }
}
