package baekjoon.dfs.safe_zone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
7
2 1 4 3 4 3 4
1 1 1 1 1 1 1
1 1 1 1 1 1 1
1 1 1 1 1 1 1
1 1 1 1 1 1 1
1 1 1 1 1 1 1
1 1 1 1 1 1 1

고통스럽게 만든 반례
if(safeZone > count) break; 이런식으로 했다. 당연히 안될 줄 알았는데
W = 1일때
2 43434 -> 2
W = 2일때
43434 -> 1   // 기존 여기서 종료
W = 3일때
4 4 4 -> 3   // 이런식으로 더 높을 수 있음.
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] Graph;
    static boolean visit[][];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int safeZone = 0;
        for (int k = -1; k < 101; k++) {
            int W = k;
            int count = 0;
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j] && Graph[i][j] > W) {
                        bfs(j, i, W);
//                        System.out.print(" ");
                        count++;
                    }
                }
            }
//            System.out.println(count + " " + W);
//            if(safeZone > count) break;
            safeZone = Math.max(safeZone, count);
        }
        System.out.println(safeZone);
    }
    static void bfs(int x, int y, int W){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visit[y][x] = true;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
//            System.out.print(Graph[tmp[0]][tmp[1]]);
            for (int i = 0; i < 4; i++) {
                int nextX = tmp[1] + dx[i];
                int nextY = tmp[0] + dy[i];
                if (nextY >= 0 && nextX >= 0 && nextX < Graph.length && nextY < Graph.length) {
                    if(!visit[nextY][nextX] && Graph[nextY][nextX] > W){
                        q.offer(new int[]{nextY, nextX});
                        visit[nextY][nextX] = true;
                    }
                }
            }
        }
    }
}
