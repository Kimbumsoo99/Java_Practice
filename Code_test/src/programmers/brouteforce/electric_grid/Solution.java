package programmers.brouteforce.electric_grid;
import java.util.*;
class Solution {
    static int[][] Graph;
    static boolean[] visit;
    public int solution(int n, int[][] wires) {
        int answer = 100;
        Graph = new int[n][n];

        for(int i=0;i<wires.length;i++){
            int a = wires[i][0] - 1;
            int b = wires[i][1] - 1;
            Graph[a][b] = Graph[b][a] = 1;
        }
        for(int[] wire : wires){
            int a = wire[0] - 1;
            int b = wire[1] - 1;
            Graph[a][b] = Graph[b][a] = 0;
            int count1 = bfs(a);
            int count2 = bfs(b);
            // System.out.println(count1 + " " + count2 + " " + Math.abs(count1 - count2));
            Graph[a][b] = Graph[b][a] = 1;
            answer = Math.min(answer, Math.abs(count1 - count2));
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(Graph[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return answer;
    }
    static int bfs(int start){
        // System.out.println(start);
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit = new boolean[Graph.length];
        visit[start] = true;
        while(!q.isEmpty()){
            // System.out.println(q.toString());
            int tmp = q.poll();
            count++;
            for(int i=0;i<Graph.length;i++){
                if(!visit[i] && Graph[tmp][i] == 1){
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
        // System.out.println(count);
        return count;
    }
}