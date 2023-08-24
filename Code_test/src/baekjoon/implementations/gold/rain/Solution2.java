package baekjoon.implementations.gold.rain;
import java.util.*;
import java.io.*;
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] map = new int[H][W];
        boolean flag = false;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            int height = Integer.parseInt(st.nextToken());
            for (int j = H-1; j >= H-height; j--) {
                map[j][i]=1;
            }
        }
        int answer = 0;
        for (int i = 0; i < H; i++) {
            int count = 0;
            flag = false;
            for (int j = 0; j < W; j++) {
                if(!flag && map[i][j]==1){// 처음 벽을 만날때,
                    flag=true;
                }
                else if(flag && map[i][j]==1){ // 두번째 벽을 만났을때
                    answer += count;
                    count = 0;
                }
                if(flag && map[i][j]==0){
                    count++;
                }
            }

        }
        System.out.println(answer);

    }
}
