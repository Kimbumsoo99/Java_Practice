package baekjoon.string.bronze.b10953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// A+B - 6, 10953번 브III
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ",");
            // String [] str = br.readLine().split(","); -> 144ms
            int A = Integer.parseInt(st.nextToken()); // str[0]
            int B = Integer.parseInt(st.nextToken()); // str[1]
            sb.append(A + B + "\n");
        }
        System.out.println(sb);

    }
}
