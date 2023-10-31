package baekjoon.implementations.silver.s13414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

// 시간초과 로직 실패
public class Fail {

    //    static HashMap<String, Integer> map = new HashMap<>();
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String tmp = br.readLine();
            if (set.contains(tmp)) {
                list.remove(list.indexOf(tmp));
            }
            list.add(tmp);
            set.add(tmp);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }

}
