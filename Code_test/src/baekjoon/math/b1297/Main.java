package baekjoon.math.b1297;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        double dRatioPow = Math.pow(H, 2) + Math.pow(W, 2);
        double dRatio = Math.sqrt(dRatioPow);
        double unit = D / dRatio;

        System.out.println((int) (unit * H) + " " + (int) (unit * W));
    }
}