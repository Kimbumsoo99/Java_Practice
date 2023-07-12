package programmers.dfs.game_map;
import java.util.*;

class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }

    static int bfs(int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        int yLength = maps.length;
        int xLength = maps[0].length;
        boolean visit[][] = new boolean[yLength][xLength];
        visit[0][0] = true;
        q.offer(new int[]{0, 0, 1});
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            // System.out.println(tmp[0] + " " + tmp[1]);
            if(tmp[0] == yLength - 1 && tmp[1] == xLength - 1){
                return tmp[2];
            }
            for(int i=0;i<4;i++){
                int nextX = tmp[1] + dx[i];
                int nextY = tmp[0] + dy[i];
                // System.out.println(nextY + " " + nextX);
                if(nextX >= 0 && nextX < xLength && nextY >= 0 && nextY < yLength){
                    if(!visit[nextY][nextX] && maps[nextY][nextX] == 1){
                        q.offer(new int[]{nextY, nextX, tmp[2] + 1});
                        visit[nextY][nextX] = true;
                    }
                }
            }
        }
        return -1;
    }
}