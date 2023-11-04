package swea.d3.n8888;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

// Fail 정답은 아마 맞는듯하고, 시간초과가 났다.
public class SolutionFail1 {
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
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < T; j++) {
                    scoreBoard[i][j] = sc.nextInt();
                }
            }
            HashMap<Integer, Integer> scoreNum = new HashMap<>();
            for (int i = 0; i < T; i++) {
                int zeroCount = 0; // 0의 갯수만큼 해당 문제 총점수
                for (int j = 0; j < N; j++) {
                    if (scoreBoard[j][i] == 0) {
                        zeroCount++;
                    }
                }
                scoreNum.put(i, zeroCount);
            }

            ArrayList<int[]> list = new ArrayList<>();
            int answerScore = 0;
            for (int i = 0; i < N; i++) {
                int playerScore = 0;
                int scoreCount = 0;
                for (int j = 0; j < T; j++) {
                    if (scoreBoard[i][j] == 1) {
                        playerScore += scoreNum.get(j);
                        scoreCount++;
                    }
                }
                if (i == P - 1) {
                    answerScore = playerScore;
                }
                list.add(new int[]{playerScore, scoreCount, i}); // 점수, 맞은 개수, 번호
            }

            Collections.sort(list, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    if (o1[1] == o2[1]) {
                        return o1[2] - o2[2];
                    }
                    return o2[1] - o1[1];
                }
                return o2[0] - o1[0];
            });

            int answerCount = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)[2] == P - 1) {
                    answerCount = i + 1;
                }
            }
            System.out.println("#" + test_case + " " + answerScore + " " + answerCount);
        }
    }
}
