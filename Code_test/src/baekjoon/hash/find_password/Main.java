package baekjoon.hash.find_password;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, String> map = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String www = st.nextToken();
            String pw = st.nextToken();
            map.put(www, pw);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String www = br.readLine();
            sb.append(map.get(www)).append("\n");
        }
        System.out.println(sb);
    }

}
