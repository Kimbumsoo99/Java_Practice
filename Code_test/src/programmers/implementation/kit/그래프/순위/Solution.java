package programmers.implementation.kit.그래프.순위;

import java.util.*;

class Solution {
    static ArrayList<Integer>[] winList;
    static ArrayList<Integer>[] loseList;
    int N;
    public int solution(int n, int[][] results) {
        N = n;
        winList = new ArrayList[101];
        loseList = new ArrayList[101];
        for(int i=0;i<101;i++){
            winList[i] = new ArrayList<>();
            loseList[i] = new ArrayList<>();
        }
        for(int i=0;i<results.length;i++){
            int[] result = results[i];
            int A = result[0];
            int B = result[1];
            winList[A].add(B);
            loseList[B].add(A);
        }

        int answer = 0;

        for(int i=1;i<=n;i++){
            boolean[] visit = new boolean[n+1];
            if(bfs(i, visit)) answer++;
        }
        return answer;
    }

    boolean bfs(int cur, boolean[] visit){
        visit[cur] = true;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.offer(cur);
        int count = 1;
        // win
        while(!dq.isEmpty()){
            int tmp = dq.pollFirst();
            for(Integer win : winList[tmp]){
                if(visit[win]) continue;
                visit[win] = true;
                if(++count == N) return true;
                dq.offer(win);
            }
        }

        dq.offer(cur);
        // lose
        while(!dq.isEmpty()){
            int tmp = dq.pollFirst();
            for(Integer lose : loseList[tmp]){
                if(visit[lose]) continue;
                visit[lose] = true;
                if(++count == N) return true;
                dq.offer(lose);
            }
        }
        return false;
    }
}