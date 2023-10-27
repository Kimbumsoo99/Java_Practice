package baekjoon.implementations.silver.ant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String groupA = br.readLine();
        String groupB = br.readLine();
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        groupA = sb.append(groupA).reverse().toString();
        String tmp = groupA + groupB;
        ArrayList<Character> antList = new ArrayList<>();
        ArrayList<Integer> direction = new ArrayList<>();
        for (int i = 0; i < tmp.length(); i++) {
            antList.add(tmp.charAt(i));
            if (i < groupA.length()) {
                direction.add(1);
            } else {
                direction.add(-1);
            }
        }

        // 교환
        for (int i = 0; i < T; i++) {
            HashSet<Integer> alreadyChange = new HashSet<>();
            for (int j = 0; j < antList.size() - 1; j++) {
                if (!alreadyChange.contains(j) && direction.get(j) == 1
                    && direction.get(j + 1) == -1) {
                    alreadyChange.add(j);
                    alreadyChange.add(j + 1);

                    // swap
                    char ant = antList.get(j);
                    antList.set(j, antList.get(j + 1));
                    antList.set(j + 1, ant);
                    direction.set(j, -1);
                    direction.set(j + 1, 1);
                }
            }
        }

        sb = new StringBuilder();
        for (int i = 0; i < antList.size(); i++) {
            sb.append(antList.get(i));
        }
        System.out.println(sb);
    }

}
