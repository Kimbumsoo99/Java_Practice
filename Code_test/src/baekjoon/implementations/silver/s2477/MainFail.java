package baekjoon.implementations.silver.s2477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참외밭, 실버II, 2477번
// 무조건 작은 부분이 빠지는 것은 아니다.
public class MainFail {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            if (D <= 2) { // 동, 서
                maxX = Math.max(maxX, length);
                minX = Math.min(minX, length);
            }else {
                maxY = Math.max(maxY, length);
                minY = Math.min(minY, length);
            }
        }
        int answer = (maxX * maxY - minX * minY) * N;
        System.out.println(maxX + " " + maxY + " " + minX + " " + minY);
    }
}
