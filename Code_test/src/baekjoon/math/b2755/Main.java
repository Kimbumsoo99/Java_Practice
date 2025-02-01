package baekjoon.math.b2755;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        double sum = 0;
        int sum_n = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int _a = Integer.parseInt(st.nextToken());
            sum_n += _a;
            sum += res(st.nextToken()) * _a;
        }
        System.out.printf("%.2f", sum / sum_n);
    }

    static double res(String a) {
        if (a.equals("A+")) {
            return 4.3;
        } else if (a.equals("A0")) {
            return 4.0;
        } else if (a.equals("A-")) {
            return 3.7;
        } else if (a.equals("B+")) {
            return 3.3;
        } else if (a.equals("B0")) {
            return 3.0;
        } else if (a.equals("B-")) {
            return 2.7;
        } else if (a.equals("C+")) {
            return 2.3;
        } else if (a.equals("C0")) {
            return 2.0;
        } else if (a.equals("C-")) {
            return 1.7;
        } else if (a.equals("D+")) {
            return 1.3;
        } else if (a.equals("D0")) {
            return 1.0;
        } else if (a.equals("D-")) {
            return 0.7;
        } else if (a.equals("F")) {
            return 0;
        }
        return 100001;
    }
}