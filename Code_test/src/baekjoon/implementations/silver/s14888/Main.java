package baekjoon.implementations.silver.s14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연산자 끼워넣기 실버 1
public class Main {

    static int[] op = new int[4]; // 덧셈, 뺄셈, 곱셈, 나눗셈
    static int[] numArr;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        numArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            numArr[i] = tmp;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        recursive(0, N, numArr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    static void recursive(int pre, int N, int sum, int depth){
//        System.out.println(depth + " " + sum + " " + pre);
        if(depth == N){
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        for (int j = 0; j < 4; j++) {
            if(op[j] > 0){
                op[j] -= 1;
                int tmp = sum;
                if(j == 0){
                    tmp += numArr[depth];
                } else if (j == 1) {
                    tmp -= numArr[depth];
                } else if (j == 2) {
                    tmp *= numArr[depth];
                } else {
                    tmp /= numArr[depth];
                }
                recursive(j, N, tmp, depth + 1);
                op[j] += 1;
            }
        }
    }
}
