package swea.d3.n8888;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

// 171,328 kb   메모리
// 1,766 ms  실행시간
// 2,549줄   코드길이
public class Solution {
    static int[][] scoreBoard;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int test_case = 1; test_case <= test; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // N명 참가자
            int T = Integer.parseInt(st.nextToken()); // 문제의 수
            int P = Integer.parseInt(st.nextToken()); // 참가자 번호
            scoreBoard = new int[N][T];
            HashMap<Integer, Integer> scoreNum = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < T; j++) {
                    scoreBoard[i][j] = Integer.parseInt(st.nextToken());
                    if (scoreBoard[i][j] == 0) {
                        scoreNum.put(j, scoreNum.getOrDefault(j, 0) + 1);
                    } else {
                        scoreNum.put(j, scoreNum.getOrDefault(j, 0));
                    }
                }
            }

            int answerScore = 0;
            int scoreCount = 0;
            for (int i = 0; i < T; i++) {
                if (scoreBoard[P - 1][i] == 1) {
                    answerScore += scoreNum.get(i);
                    scoreCount++;
                }
            }

            int answerCount = 1;
            for (int i = 0; i < N; i++) {
                if (i == P - 1) {
                    continue;
                }
                int tmpScore = 0;
                int tmpCount = 0;
                for (int j = 0; j < T; j++) {
                    if (scoreBoard[i][j] == 1) {
                        tmpScore += scoreNum.get(j);
                        tmpCount++;
                    }
                }
                if (answerScore < tmpScore ||
                    (answerScore == tmpScore && scoreCount < tmpCount) ||
                    (answerScore == tmpScore && scoreCount == tmpCount && i < P - 1)) {
                    answerCount++;
                }
            }
            System.out.println("#" + test_case + " " + answerScore + " " + answerCount);
        }
    }
}
