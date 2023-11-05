package baekjoon.greedy.s1417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 국회의원 선거
// 그리디적 사고가 부족했다. 반례 케이스
//3
//0
//1
//5

// 3번에서만 3개를 뽑아오면 되는데, 지금 번갈아가면서 빼고있는중.
public class MainFail {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] vote = new int[N];
        for (int i = 0; i < N; i++) {
            vote[i] = Integer.parseInt(br.readLine());
        }
        int voting = vote[0]; // 다솜의 표 수
        int count = 0;
        while (true) {
            int voteCount = 0;
            for (int i = 1; i < N; i++) {
                if (voting < vote[i]) {
                    vote[i]--;
                    vote[0]++;
                    voting++; // 다솜의 표 수 증가
                    count++; // 전체 정답 (매수한 사람 수)
                    voteCount++; // 한 번의 반복에서 증가가 한 번이라도 있던 경우
                }
            }
            if (voteCount == 0) {
                break;
            }
        }
        if (sameVoting(vote, voting)) {
            count++;
        }
        System.out.println(count);
    }

    private static boolean sameVoting(int[] vote, int voting) {
        for (int i = 1; i < vote.length; i++) {
            if (voting == vote[i]) {
                return true;
            }
        }
        return false;
    }

}
