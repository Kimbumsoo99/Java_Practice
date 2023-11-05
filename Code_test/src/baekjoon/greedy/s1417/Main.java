package baekjoon.greedy.s1417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 국회의원 선거
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] vote = new int[N];
        int maxIndex = 0;
        int maxVoting = -1;

        for (int i = 0; i < N; i++) {
            vote[i] = Integer.parseInt(br.readLine());
            if (vote[i] > maxVoting) {
                maxVoting = vote[i];
                maxIndex = i;
            }
        }

        if (maxIndex == 0 && !same(vote, vote[0])) {
            System.out.println(0);
            return;
        }

        int count = 0;
        while (maxIndex != 0) {
            vote[maxIndex]--;
            vote[0]++;
            maxVoting--;
            count++;
            for (int i = 0; i < N; i++) {
                if (maxVoting < vote[i]) {
                    maxVoting = vote[i];
                    maxIndex = i;
                }
            }
        }
        if (same(vote, vote[0])) {
            count++;
        }
        System.out.println(count);


    }

    private static boolean same(int[] vote, int i) {
        for (int j = 1; j < vote.length; j++) {
            if (vote[j] == i) {
                return true;
            }
        }
        return false;
    }
}
