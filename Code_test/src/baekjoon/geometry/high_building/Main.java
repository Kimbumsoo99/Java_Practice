package baekjoon.geometry.high_building;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] building;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        building = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            double left = 0;
            double right = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (j == i - 1 || left > (double) (building[i] - building[j]) / (i - j)) {
                    left = (double) (building[i] - building[j]) / (i - j);
                    count++;
                }
            }
            for (int j = i + 1; j < N; j++) {
                if (j == i + 1 || right < (double) (building[i] - building[j]) / (i - j)) {
                    right = (double) (building[i] - building[j]) / (i - j);
                    count++;
                }
            }
            max = Math.max(count, max);
        }
        System.out.println(max);
    }

}
