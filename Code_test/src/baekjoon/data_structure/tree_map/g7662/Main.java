package baekjoon.data_structure.tree_map.g7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 이중 우선순위 큐, 트리맵 풀이(우선순위 큐도 풀이 따로 있음)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (cmd.equals("I")) {
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                }else{
                    if (treeMap.isEmpty()) {
                        continue;
                    }
                    int val;
                    if (num == 1) {
                        val = treeMap.lastKey();
                    } else {
                        val = treeMap.firstKey();
                    }
                    if (treeMap.put(val, treeMap.get(val) - 1) == 1) {
                        treeMap.remove(val);
                    }
                }
            }
            if(treeMap.isEmpty()){
                System.out.println("EMPTY");
            }else {
                System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
            }
        }
    }
}
