package swea.d4.n8458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Point {
    int y, x, distance;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
        this.distance = Math.abs(y) + Math.abs(x);
    }

    @Override
    public String toString() {
        return "Point{" +
                "y=" + y +
                ", x=" + x +
                '}';
    }
}

public class Solution {
    static int answer = 0, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int test_case = 1; test_case < T + 1; test_case++) {
            N = Integer.parseInt(br.readLine());
            answer = 0;
            int odd = 0;
            st = new StringTokenizer(br.readLine());
            Point first = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            int max = first.distance;
            odd = first.distance % 2;
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                Point tmp = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                if (tmp.distance % 2 != odd) {
                    answer = -1;
                }
                max = Math.max(max, tmp.distance);
            }

            if (answer == -1) {
                System.out.println("#" + test_case+" " + answer);
            }else{
                long sum = 0L;
                int i = 0;
                while (sum < max || sum % 2 != odd) {
                    sum += ++i;
                }
                answer = i;
                System.out.println("#" + test_case+" " + answer);
            }
        }
    }
}
