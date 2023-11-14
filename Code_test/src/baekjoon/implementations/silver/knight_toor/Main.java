package baekjoon.implementations.silver.knight_toor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[][] Graph = new boolean[6][6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String start = br.readLine();
        int startY = start.charAt(1) - '1';
        int startX = start.charAt(0) - 'A';
        int[] last = new int[]{startY, startX};

        for (int i = 1; i < 36; i++) {
            String tmp = br.readLine();
            int y = tmp.charAt(1) - '1';
            int x = tmp.charAt(0) - 'A';
            // 1. 중복 여부 확인
            if (Graph[y][x]) {
                System.out.println("Invalid");
                return;
            }
            // 2. 나이트 이동 가능한 위치에 다음 위치가 존재하는 지 확인한다.
            if (
                !((Math.abs(last[0] - y) == 1 && Math.abs(last[1] - x) == 2) ||
                (Math.abs(last[0] - y) == 2 && Math.abs(last[1] - x) == 1))
            ) {
                System.out.println("Invalid");
                return;
            }

            Graph[y][x] = true;
            last[0] = y;
            last[1] = x;
        }
        // 3. 마지막 지점인 경우 start 로 다시 이동할 수 있는지 확인한다.
        if (
            !((Math.abs(last[0] - startY) == 1 && Math.abs(last[1] - startX) == 2) ||
                (Math.abs(last[0] - startY) == 2 && Math.abs(last[1] - startX) == 1))
        ) {
            System.out.println("Invalid");
            return;
        }

        System.out.println("Valid");
    }

}
