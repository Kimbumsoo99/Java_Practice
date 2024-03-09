package baekjoon.string.silver.s9996;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] pattern;
    static boolean[] visit;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pattern = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            visit = new boolean[tmp.length];
            if(!wordStart(tmp)){
                isPattern(false);
                continue;
            }
            isPattern(wordEnd(tmp));
        }
        System.out.println(sb);
    }

    static boolean wordStart(char[] arr){
        int idx = 0;
        while (true) {
            if (pattern[idx] == '*') {
                return true;
            }
            if (pattern[idx] == arr[idx] && !visit[idx]) {
                visit[idx] = true;
                idx++;
            } else {
                break;
            }
        }
        return false;
    }

    static boolean wordEnd( char[] arr){
        int idx = arr.length - 1;
        int pIdx = pattern.length - 1;
        while (true) {
            if (pattern[pIdx] == '*') {
                return true;
            }
            if (pattern[pIdx] == arr[idx] && !visit[idx]) {
                visit[idx] = true;
                pIdx--;
                idx--;
            } else {
                return false;
            }
        }
    }
    static void isPattern(boolean b){
        sb.append(b ? "DA\n" : "NE\n");
    }

}
