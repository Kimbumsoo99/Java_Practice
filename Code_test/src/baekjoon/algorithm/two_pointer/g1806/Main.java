package baekjoon.algorithm.two_pointer.g1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int sum = arr[start];
        if(sum >= S){
            System.out.println(1);
            return;
        }
        int end = 1;
        int answer = Integer.MAX_VALUE;
        while (start < N){
//            System.out.println(sum);
            if(sum < S){
                if(end == N) break;
                sum += arr[end];
                end++;
            }else{
                answer = Math.min(end - start, answer);
                sum -= arr[start++];
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
