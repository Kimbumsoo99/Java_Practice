package baekjoon.hash.fashion_king;
import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            test();
        }
        System.out.println(sb);
    }
    static void test() throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String T = st.nextToken();
            String O = st.nextToken();
            map.put(O, map.getOrDefault(O, 1) + 1);
//            System.out.println(O + " " + map.get(O));
        }

        Iterator<Integer> it = map.values().iterator();
        int tmp = 1;
        while (it.hasNext()){
            tmp *= it.next();
        }
        sb.append(tmp-1).append("\n");
    }
}
