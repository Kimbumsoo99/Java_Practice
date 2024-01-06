package baekjoon.implementations.gold.lie;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

// HashSet으로 풀려고 했지만, 그렇게 풀기는 좀 빡세보이는 문제이다.
// 그래프 탐색으로 풀어야하는 문제인 듯 하다.
public class Fail {

    static HashSet<Integer> knowSet = new HashSet<>();
    static HashSet<Integer> unknown = new HashSet<>();
    static int[][] finalS;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        finalS = new int[M][N + 1];
        for (int i = 0; i < K; i++) {
            int tmp = sc.nextInt();
            knowSet.add(tmp);
        }

        for (int i = 0; i < M; i++) {
            int L = sc.nextInt(); // 파티의 참여 인원 수
            int[] S = new int[L];
            finalS[i][0] = L;
            boolean knowFlag = false;
            for (int j = 0; j < L; j++) {
                int tmp = sc.nextInt();
                if (knowSet.contains(tmp)) {
                    knowFlag = true;
                }
                S[j] = tmp;
                finalS[i][j + 1] = tmp;
            }
            for (int j = 0; j < L; j++) {
                if (knowFlag) {
                    if (unknown.contains(S[j])) {
                        unknown.remove(S[j]);
                    }
                    knowSet.add(S[j]);
                } else {
                    unknown.add(S[j]);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            int L = finalS[i][0];
            boolean countFlag = true;
            for (int j = 1; j <= L; j++) {
                if (knowSet.contains(finalS[i][j])) {
                    countFlag = false;
                    break;
                }
            }
            if (countFlag) {
                count++;
            }
        }
        System.out.println(count);
    }
}
