package baekjoon.implementations.silver.s13414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

// https://velog.io/@jh5253/%EB%B0%B1%EC%A4%80-13414-%EC%88%98%EA%B0%95%EC%8B%A0%EC%B2%AD-Java-%EC%9E%90%EB%B0%94
// 위 링크 글 참고해서 풀었음.
public class CountSolution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<String> list = new ArrayList<>(); // 학번 순서대로 저장
        HashMap<String, Integer> map = new HashMap<>(); // 학번, count
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            String tmp = br.readLine();
            list.add(tmp);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        for (String tmp : list) {
            map.put(tmp, map.get(tmp) - 1);
            if (map.get(tmp) == 0) {
                System.out.println(tmp);
                N--;
                if (N == 0) {
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(sb);
    }
}
