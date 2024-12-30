package baekjoon.data_structure.tree_set.s1822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        TreeSet<Integer> setA = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<A; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int j=0; j<B; j++) {
            int tmp = Integer.parseInt(st.nextToken());
            setA.remove(tmp);
        }

        sb.append(setA.size()).append("\n");
        for (Integer num : setA) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}