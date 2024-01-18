package baekjoon.backtracking.gold.g2591;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] P = str.toCharArray();


        int[] ans = new int[P.length];
        ans[0] = P[0] - '0';
        recur(P, 1, ans, 1, P.length); // 기존 배열, next, 만들 배열, 저장 위치, 배열 길이
        if(P.length > 1 && (P[0] - '0') * 10 + (P[1] - '0') < 35) {
            ans[0] = (P[0] - '0') * 10 + (P[1] - '0');
            recur(P, 2, ans, 1, P.length);
        }
        System.out.println(count);
    }

    static void recur(char[] P, int next, int[] card, int idx, int N) {
        if(next == N) {
            // System.out.println(Arrays.toString(card));
            count++;
            return;
        }
        if(P[next] == '0') return;
        card[idx] = P[next] - '0';
        recur(P, next+1, card,idx+1,N);
        if(next +1 < N && (P[next] - '0') * 10 + (P[next+1] - '0') < 35) {
            card[idx] = (P[next] - '0') * 10 + (P[next+1] - '0');
            recur(P, next+2, card, idx+1, N);
        }
    }

}
