package swea.tbd.n5644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    static int M, A, answer = 0, Graph[][] = new int[11][11]; // A는 1,1, B는 10,10
    static ArrayList<Battery> bcList = new ArrayList<>();
    static ArrayDeque<int[]> moved;
    static int[] dx = new int[] { 0, 0, 1, 0, -1 }, dy = { 0, -1, 0, 1, 0 }; // X, 상, 우, 하, 좌

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int test_case = 1; test_case < T + 1; test_case++) {
            st = new StringTokenizer(br.readLine());
            bcList = new ArrayList<>();
            moved = new ArrayDeque<>();
            answer = 0;
            M = Integer.parseInt(st.nextToken()); // 이동 시간
            A = Integer.parseInt(st.nextToken()); // BC의 개수

            moved.offer(new int[] { 0, 0 }); // 첫 시작은 둘 다 0,0 이동
            int[] S = new int[M];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    if (i == 0)
                        S[j] = Integer.parseInt(st.nextToken());
                    else
                        moved.offer(new int[] { S[j], Integer.parseInt(st.nextToken()) });
                }
            }

            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                bcList.add(new Battery(y, x, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            // 파워가 쎈 ~ 작은 순서로 0 ~ A
            Collections.sort(bcList, (o1, o2) -> o2.power - o1.power);
            charger();
            System.out.println("#" + test_case + " " + answer);
        }
    }

    static void charger() {
        int A[] = { 1, 1 };
        int B[] = { 10, 10 };
        int idx = 0;
        while (!moved.isEmpty()) {
            int tmp[] = moved.pollFirst();
            A[0] += dy[tmp[0]];
            A[1] += dx[tmp[0]];
            B[0] += dy[tmp[1]];
            B[1] += dx[tmp[1]];
//			System.out.println("A : " + Arrays.toString(A) + " B : " + Arrays.toString(B));
            int flagA = 0;
            int flagB = 0;
            for (int i = 0; i < bcList.size(); i++) {
                Battery battery = bcList.get(i);
                if (Math.abs(battery.y - A[0]) + Math.abs(battery.x - A[1]) <= battery.range) {
                    flagA = flagA | (1 << i);
                }
                if (Math.abs(battery.y - B[0]) + Math.abs(battery.x - B[1]) <= battery.range) {
                    flagB = flagB | (1 << i);
                }
            }
            if ((flagA & flagB) == 0) { // 겹치는게 없는 경우
                answer += getPower(flagA);
//				System.out.println("A 추가 " + getPower(flagA));
                answer += getPower(flagB);
//				System.out.println("B 추가 " + getPower(flagB));
            } else { // 겹치는게 있는 경우
                int count = 0;
                boolean a = false;
                boolean b = false;
                for (int i = 0; i < bcList.size(); i++) {
                    if ((flagA & (1 << i)) != 0 && (flagB & (1 << i)) != 0) {
                        answer += bcList.get(i).power;
                        count++;
                    } else if (!a && (flagA & (1 << i)) != 0) {
                        answer += bcList.get(i).power;
                        a = true;
                        count++;
                    } else if (!b && (flagB & (1 << i)) != 0) {
                        answer += bcList.get(i).power;
                        b = true;
                        count++;
                    }

                    if (count == 2)
                        break;
                }
            }
//			System.out.println(idx++ + " " + answer);
        }
    }

    static int getPower(int flag) {
        if (flag == 0)
            return 0;
        for (int i = 0; i < bcList.size(); i++) {
            if ((flag & (1 << i)) != 0) {
                return bcList.get(i).power;
            }
        }
        return 0;
    }
}

class Battery {
    int y;
    int x;
    int range;
    int power;

    public Battery(int y, int x, int range, int power) {
        this.x = x;
        this.y = y;
        this.range = range;
        this.power = power;
    }
}
