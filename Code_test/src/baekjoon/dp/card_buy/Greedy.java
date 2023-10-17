package baekjoon.dp.card_buy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

// 실패했다.
//
/*
12
1 1 6 8 11 1 1 1 1 1 1 1
 */
// 위 부분은 반례로 사용된 문자열인데, 해당 정답은 5, 4, 3 한 개씩 사는 것으로 반례에 걸린다.
public class Greedy {
    static int[] S;
    static double[] DivS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<double[]> list = new ArrayList<>();
        S = new int[N + 1];
        DivS = new double[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            S[i] = Integer.parseInt(st.nextToken());
            list.add(new double[]{i, (double) S[i] / i});
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1[1] > o2[1]) {
                return -1;
            }
            return 1;
        });
        int answer = 0;
        for (double[] tmp : list) {
            System.out.println(N + " " + tmp[0]);
            if (N > (int) tmp[0]) { // 12 > 5
                int count = N / (int) tmp[0]; // 12 / 5
                answer += (int) (S[(int) tmp[0]] * count); // 11 * 2
                System.out.println(" " + answer);
                N %= tmp[0];
                if (N == 0) {
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
