package swea.d3.n8888;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
// 107,844 kb   메모리
// 526 ms   실행시간
public class OtherSolution3 {


        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        static StringTokenizer st = null;
        static StringBuilder sb = new StringBuilder();

        public static void main(String[] args) throws NumberFormatException, IOException {

            int T = Integer.parseInt(br.readLine());
            for (int tc = 1; tc <= T; tc++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken()) - 1;

                boolean[][] solved = new boolean[n][t];
                int[] score = new int[t];
                int[][] total = new int[n][2]; // 점수, 푼 문제의 숫자
                for (int i = 0; i < n; i++) {
                    char[] line = br.readLine().toCharArray();
                    for (int j = 0; j < t; j++) {
                        if (line[j << 1] == '1') {
                            solved[i][j] = true;
                            total[i][1]++;
                        } else {
                            solved[i][j] = false;
                            score[j]++;
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < t; j++) {
                        if (solved[i][j]) {
                            total[i][0] += score[j];
                        }
                    }
                }
                int ans = 0;
                int a = total[p][0]; // 자신보다 많은 점수를 획득한 참가자의 수
                int b = total[p][1]; // 자신과 같은 점수를 획득하였지만 더 많은 문제를 푼 참가자의 수
                int c = 0; // 자신과 같은 점수를 획득하고 같은 수의 문제를 풀었지만 번호가 더 작은 참가자의 수

                for (int i = 0; i < n; i++) {
                    if (total[i][0] > a) { // 점수가 높은 사람
                        ans++;
                    } else if (total[i][0] == a) { // 점수가 같은 사람
                        if (total[i][1] > b) { // 맞은 개수가 더 많은 사람
                            ans++;
                        } else if (total[i][1] == b) { // 같은 개수
                            if (i < p) { // 번호가 더 작은 사람
                                ans++;
                            }
                        }
                    }
                }

                sb.append("#" + tc + " " + a + " " + (ans + 1) + "\n");
            }
            bw.write(sb.toString());
            bw.flush();
        }

}
