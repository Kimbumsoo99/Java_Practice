package baekjoon.implementations.bronze.b4493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int ans = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                char a = st.nextToken().charAt(0);
                char b = st.nextToken().charAt(0);
                ans += res(a, b);
            }

            if (ans > 0) {
                sb.append("Player 1\n");
            } else if (ans < 0) {
                sb.append("Player 2\n");
            } else {
                sb.append("TIE\n");
            }
        }
        System.out.println(sb);
    }

    static int res(char a, char b) {
        // R 바위, P 보, S 가위
        if (a == b) {
            return 0;
        } else if ((a == 'R' && b == 'P') || (a == 'P' && b == 'S') || (a == 'S' && b == 'R')) {
            return -1;
        } else if ((a == 'R' && b == 'S') || (a == 'S' && b == 'P') || (a == 'P' && b == 'R')) {
            return 1;
        }
        return 100;
    }
}