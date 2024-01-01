package baekjoon.greedy.s1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<int[]> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int tmp = Integer.parseInt(st.nextToken());
                int tmp2 = Integer.parseInt(st.nextToken());
                list.add(new int[]{tmp, tmp2});
            }
            // 아래는 오름차순 정렬이다.
            Collections.sort(list,(o1, o2) -> {
                return o1[0] - o2[0];
            });

            int interviewMax = list.get(0)[1];

            int count = 0;
            boolean countFlag; //
            for (int i = 0; i < N; i++) {
                countFlag = true;
                if (list.get(i)[1] > interviewMax) {
                    countFlag = false;
                }else {
                    interviewMax = list.get(i)[1];
                }

                if (countFlag) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
