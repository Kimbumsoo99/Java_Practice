package baekjoon.backtracking.silver.n_and_m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N = 0;
    static int M = 0;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N];
        arr = new int[M];

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int count){
        if (M == count) {
            for(int tmp : arr){
                sb.append(tmp).append(" ");
            }
            sb.append("\n");
            return;
        }
//        draw();
        for (int i = 0; i < N; i++) {
            if(!visit[i]){
//                System.out.println(i+1);
                visit[i] = true;
                arr[count] = i + 1;
                dfs(count + 1);
                visit[i] = false;
            }

//            sb.append(current).append(" ");
        }
    }
    static void draw(){
        for (int i = 0; i < visit.length; i++) {
            System.out.print(visit[i] + " ");
        }
        System.out.println();
    }
}
