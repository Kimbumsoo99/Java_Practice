package baekjoon.implementations.silver.s2564;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 경비원, 실버 I, 2564번
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int shop = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < shop; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int rightDown = Integer.parseInt(st.nextToken());
            list.add(directionMap(direction, X, Y, rightDown));
        }
        st = new StringTokenizer(br.readLine());
        int startD = Integer.parseInt(st.nextToken());
        int startRD = Integer.parseInt(st.nextToken());
        int start[] = directionMap(startD, X, Y, startRD);

        int answer = 0;
        // 시계, 반시계 해결
        for (int tmp[] : list) {
            int shortRange = 0;
            if (tmp[0] == start[0]) { // 같은 동서남북
//                System.out.println("같은 위치");
                shortRange = Math.abs(Math.abs(tmp[1] - start[1]) + Math.abs(tmp[2] - start[2]));
            } else if (Math.abs(tmp[0] - start[0]) == 1 && !((tmp[0] == 2 && start[0] == 3)
                || (tmp[0] == 3 && start[0] == 2))) { // 건너 편
//                System.out.println("건너 편");
//                System.out.println(tmp[1] + " " + start[1] + " " + tmp[2] + " " + start[2]);
                shortRange = Math.abs(Math.abs(tmp[1] - start[1]) + Math.abs(tmp[2] - start[2]));
                if (tmp[0] == 1 || tmp[0] == 2) {
                    shortRange += Math.min(Math.min(tmp[1], start[1]) * 2,
                        Math.min(X - tmp[1], X - start[1]) * 2);
                } else {
                    shortRange += Math.min(Math.min(tmp[2], start[2]) * 2,
                        Math.min(Y - tmp[2], Y - start[2]) * 2);
                }
            } else { // 그 외 -> 바로 옆
//                System.out.println("바로 옆");
                shortRange = Math.abs(Math.abs(tmp[1] - start[1]) + Math.abs(tmp[2] - start[2]));
            }
//            System.out.println("shortRange = " + shortRange);
            answer += shortRange;
        }
        System.out.println(answer);
    }
    static int[] directionMap(int d, int X, int Y, int rightDown) {
        if (d == 1) {
            return new int[]{d, rightDown, 0};
        } else if (d == 2) {
            return new int[]{d, rightDown, Y};
        } else if (d == 3) {
            return new int[]{d, 0, rightDown};
        }else {
            return new int[]{d, X, rightDown};
        }
    }


}
