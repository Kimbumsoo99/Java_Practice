package baekjoon.implementations.bronze.b10824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long N = Long.parseLong(st.nextToken() + st.nextToken());
        Long M = Long.parseLong(st.nextToken() + st.nextToken());
        System.out.println(N + M);
    }

}
