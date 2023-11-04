package swea.d3.n8888;
import java.util.HashMap;
import java.util.Scanner;

public class SolutionFail2 {
    static int[][] scoreBoard;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test;
        test = sc.nextInt();

        for (int test_case = 1; test_case <= test; test_case++) {
            int N = sc.nextInt(); // N명 참가자
            int T = sc.nextInt(); // 문제의 수
            int P = sc.nextInt(); // 참가자 번호
            scoreBoard = new int[N][T];
            HashMap<Integer, Integer> scoreNum = new HashMap<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < T; j++) {
                    scoreBoard[i][j] = sc.nextInt();
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
