package baekjoon.implementations.bronze.b9093;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 단어 뒤집기
public class Main {

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
//                String tmp = st.nextToken();
                StringBuilder tmp = new StringBuilder(st.nextToken());
//                for (int j = tmp.length() - 1; j >= 0; j--) {
//                    sb.append(tmp.charAt(j));
//                }
                sb.append(tmp.reverse()+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
