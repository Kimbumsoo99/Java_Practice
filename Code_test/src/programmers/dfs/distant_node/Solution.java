package programmers.dfs.distant_node;

import java.util.*;
class Solution {
    static ArrayList<ArrayList<Integer>> Graph = new ArrayList<>();
    static boolean[] visit;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        visit = new boolean[n];
        for(int i=0;i<n;i++){
            Graph.add(new ArrayList<Integer>());
        }
        for(int[] vertex:edge){
            int A = vertex[0] - 1;
            int B = vertex[1] - 1;
            Graph.get(A).add(B);
            Graph.get(B).add(A);
        }

        answer = bfs(0);
        return answer;
    }

    static int bfs(int start){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{start, 0});
        visit[start] = true;
        int max = 0;
        int count = 0;
        while(!dq.isEmpty()){
            int[] tmp = dq.pollFirst();
            if(max < tmp[1]) {
                max = tmp[1];
                count = 0;
            }
            count++;
            for(int i=0;i<Graph.size();i++){
                if(!visit[i] && Graph.get(tmp[0]).contains(i)){
                    dq.offer(new int[]{i, tmp[1] + 1});
                    visit[i] = true;
                }
            }
        }

        return count;
    }
}
