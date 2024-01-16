package baekjoon.algorithm.sieve_of_eratosthenes.g2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 두잇 예제, 골드 5, 신기한 소수
public class Main {

    static ArrayList<Integer> answerList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        dfs(2, 1, N);
        dfs(3, 1, N);
        dfs(5, 1, N);
        dfs(7, 1, N);
        Collections.sort(answerList);
        StringBuilder sb = new StringBuilder();
        for (int answer : answerList) {
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int num, int depth, int N){
        if (depth == N) {
            if (isPrime(num)) {
                answerList.add(num);
            }
            return;
        }

        for (int i = 1; i <= 9; i+=2) {
            int next = num * 10 + i;
            if(isPrime(next)){
                dfs(num * 10 + i, depth + 1, N);
            }
        }

    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
