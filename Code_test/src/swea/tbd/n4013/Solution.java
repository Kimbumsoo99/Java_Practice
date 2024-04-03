package swea.tbd.n4013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Gear {
    int[] magnet = new int[8];
    int point;
    int leftIdx;
    int rightIdx;

    public Gear(int[] magnet) {
        super();
        this.magnet = magnet;
        this.leftIdx = 6;
        this.rightIdx = 2;
        this.point = 0;
    }

    @Override
    public String toString() {
        return "Gear [magnet=" + Arrays.toString(magnet) + ", point=" + point + ", leftIdx=" + leftIdx + ", rightIdx="
                + rightIdx + "]";
    }

}

public class Solution {
    static int N, answer;
    static int[] dx = { 1, -1 };
    static Gear[] gears;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            gears = new Gear[4];
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                int[] m = new int[8];
                for (int j = 0; j < 8; j++) {
                    m[j] = Integer.parseInt(st.nextToken());
                }
                gears[i] = new Gear(m);
            }
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken()) - 1;
                int turn = Integer.parseInt(st.nextToken()); // 시계는 1, 반시계 -1
                Gear current = gears[idx];
                // 돌리기 전에 자석 정보
                int left = current.magnet[current.leftIdx];
                int right = current.magnet[current.rightIdx];
                // 돌리기
                turnGear(turn, gears[idx]);

                lDfs(current, idx - 1, left, turn);
                rDfs(current, idx + 1, right, turn);
            }
            answer = 0;
            int flag = 0;
            for (int i = 0; i < 4; i++) {
                flag = (flag | (gears[i].magnet[gears[i].point] << i));
            }
            answer = flag;
            System.out.println("#" + test_case + " " + answer);
        }
    }

    static void lDfs(Gear pre, int cur, int notTurnPreRight, int turn) {
        if (cur < 0)
            return;
        Gear current = gears[cur];
        if (notTurnPreRight != current.magnet[current.rightIdx]) {
            int left = current.magnet[current.leftIdx];
            turnGear(-turn, current);
            lDfs(current, cur - 1, left, -turn);
        } else {
            return;
        }
    }

    static void rDfs(Gear pre, int cur, int notTurnPreRight, int turn) {
        if (cur > 3)
            return;
        Gear current = gears[cur];
        if (notTurnPreRight != current.magnet[current.leftIdx]) {
            // 다르다면 할 일
            // 1. 오른쪽 톱니가 돌아가야 하므로, 돌아가기 전 오른쪽 톱니 정보 저장
            int right = current.magnet[current.rightIdx];
            // 2. 오른쪽 톱니 돌리기(pre에서 돈 방향과 반대로 돌리기 ( 시계 -> 반시계 ))
            turnGear(-turn, current);
            // 3. 이어진 다른 톱니 확인
            rDfs(current, cur + 1, right, -turn);
        } else {
            return;
        }
    }

    static void turnGear(int t, Gear g) {
        g.point -= t;
        g.rightIdx -= t;
        g.leftIdx -= t;

        g.point += 8;
        g.rightIdx += 8;
        g.leftIdx += 8;

        g.point %= 8;
        g.rightIdx %= 8;
        g.leftIdx %= 8;
    }
}
