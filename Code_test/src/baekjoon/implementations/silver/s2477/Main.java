package baekjoon.implementations.silver.s2477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visit = new boolean[5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int[] D = new int[6];
        int[] length = new int[6];
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            D[i] = Integer.parseInt(st.nextToken());
            length[i] = Integer.parseInt(st.nextToken());
            if (D[i] <= 2) {
                maxX = Math.max(maxX, length[i]);
            } else {
                maxY = Math.max(maxY, length[i]);
            }
        }
//        System.out.println(maxX + " " + maxY);

        for (int i = 0; i < 6; i++) {
            if (length[i] == maxX && length[(i + 1) % 6] == maxY) {
//                System.out.println(i + " " + (i + 1) % 6 + " " + length[(i + 3) % 6] * length[(i + 4) % 6]);
                int answer = (maxX * maxY - length[(i + 3) % 6] * length[(i + 4) % 6]) * N;
                System.out.println(answer);
                break;
            } else if (length[i] == maxX && length[(i + 5) % 6] == maxY) {
//                System.out.println(i + " " + (i + 5) % 6 + " " + length[(i + 3) % 6] * length[(i + 2) % 6]);
                int answer = (maxX * maxY - length[(i + 3) % 6] * length[(i + 2) % 6]) * N;
                System.out.println(answer);
                break;
            }
        }

    }
}
