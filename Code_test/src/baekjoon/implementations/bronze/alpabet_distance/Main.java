package baekjoon.implementations.bronze.alpabet_distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            sb.append("Distances: ");
            st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            for (int j = 0; j < str1.length(); j++) {
                int num = str2.charAt(j) > str1.charAt(j) ? str2.charAt(j) - str1.charAt(j) : str2.charAt(j) - str1.charAt(j) + 26;
                sb.append(num != 26 ? num : 0).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
