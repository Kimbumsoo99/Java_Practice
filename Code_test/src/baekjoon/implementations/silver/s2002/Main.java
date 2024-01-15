package baekjoon.implementations.silver.s2002;
// 실버 1, 추월
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static HashMap<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            map.put(tmp, i);
        }

        int idx = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            visit[map.get(tmp)] = true;
            if(map.get(tmp) == idx) {
                while(idx < N && visit[idx]) {
                    idx++;
                }
            }else {
                count++;
            }
        }
        System.out.println(count);
    }
}
