package baekjoon.sort.conting_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void solution1(int N, int[] arr){
        int[] cnt = new int[10001];
        for(int i=0;i<N;i++){
            cnt[arr[i]]++;
        }
//        for(int i=0;i<10001;i++){
//            System.out.print(cnt[i] +" ");
//        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<10001;i++){
            while (cnt[i] > 0){
                sb.append(i).append("\n");
                cnt[i]--;
            }
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        solution1(N, arr);
//        Arrays.sort(arr);
//        StringBuilder sb = new StringBuilder();
//        for(int i=0;i<N;i++){
//            sb.append(arr[i]).append("\n");
//        }
//        System.out.println(sb.toString());
    }
}
