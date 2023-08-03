package baekjoon.dp.made_one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int answer = Integer.MAX_VALUE;
    static Integer[] dpArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dpArr = new Integer[N + 1];
        dp(N, 0);
        System.out.println(answer);
    }

    static void dp(int N, int count) {
//        System.out.println(N + " " + count);
        if (dpArr[N] == null || dpArr[N] > count) {
            dpArr[N] = count;
        }else {
            return;
        }

        if (N == 1) {
            answer = Math.min(answer, count);
            return;
        }

        if (N % 3 == 0) {
            dp(N / 3, count + 1);
        }
        if (N % 2 == 0) {
            dp(N / 2, count + 1);
        }
        if (N > 1) {
            dp(N - 1, count + 1);
        }
    }

    // 다른 사람 풀이 1
    static int recur(int num, int count) {
        if (num < 2) {
            return count;
        }

    /*
	 N으로 각각 2와 3으로 나누면 count는 +1에 각 연산의
	 나머지 값을 더해준 것이 된다.
	 나머지 값은 빼기 1했을 때의 count 값과 같기 때문
	*/
        return Math.min(recur(num / 2, count + 1 + (num % 2)), recur(num / 3, count + 1 + (num % 3)));
    }

    // 다른 사람 풀이 2
    static int recur2(int N) {

        if (dpArr[N] == null) {
            // 6으로 나눠지는 경우
            if (N % 6 == 0) {
                dpArr[N] = Math.min(recur2(N - 1), Math.min(recur2(N / 3), recur2(N / 2))) + 1;
            }
            // 3으로만 나눠지는 경우
            else if (N % 3 == 0) {
                dpArr[N] = Math.min(recur2(N / 3), recur2(N - 1)) + 1;
            }
            // 2로만 나눠지는 경우
            else if (N % 2 == 0) {
                dpArr[N] = Math.min(recur2(N / 2), recur2(N - 1)) + 1;
            }
            // 2와 3으로 나누어지지 않는 경우
            else {
                dpArr[N] = recur2(N - 1) + 1;
            }
        }
        return dpArr[N];
    }
}
