package baekjoon.algorithm.bit_masking.s2961;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[][];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][];
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[i] = new int[] { A, B };
        }

        binarySearch();
        System.out.println(min);
    }

    static void binarySearch() {
        for (int i = 0, caseCount = 1 << N; i < caseCount; i++) {
            int a = 1; // 신
            int b = 0; // 쓴
            boolean flag = false;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    a *= arr[j][0];
                    b += arr[j][1];
                    flag = true;
                }
            }
            if (flag)
                min = Math.min(min, Math.abs(a - b));
        }
    }
}

