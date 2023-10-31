package baekjoon.implementations.silver.s13414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static HashMap<String, Integer> map = new HashMap<>();
    static HashMap<Integer, String> whereTmp = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            String tmp = br.readLine();
            if (map.containsKey(tmp)) {
                whereTmp.remove(map.get(tmp));
            }
            map.put(tmp, i);
            whereTmp.put(i, tmp);
        }
        ArrayList<Integer> idxList = new ArrayList<>(map.values());
        Collections.sort(idxList);

        StringBuilder sb = new StringBuilder();
        for (int i : idxList) {
            if (N == 0) {
                break;
            }
            sb.append(whereTmp.get(i)).append("\n");
            N--;
        }
        System.out.println(sb);
    }

}
