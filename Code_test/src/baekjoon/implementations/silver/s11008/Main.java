package baekjoon.implementations.silver.s11008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 복붙의 달인, 실버 V, 11008번
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String answer = st.nextToken();
            int count = 0;
            String clip = st.nextToken();
            int length = clip.length();
            while (answer.length() > 0) {
                if (answer.length() >= length && answer.substring(0, length).equals(clip)) {
                    count++;
                    answer = answer.substring(length);
                }else{
                    count++;
                    answer = answer.substring(1);
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
