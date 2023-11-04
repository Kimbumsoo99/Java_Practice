package baekjoon.greedy.treasure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> aList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            aList.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> bList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            bList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(aList);
        Collections.sort(bList, Collections.reverseOrder());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += aList.get(i) * bList.get(i);
        }
        System.out.println(answer);
    }

}
