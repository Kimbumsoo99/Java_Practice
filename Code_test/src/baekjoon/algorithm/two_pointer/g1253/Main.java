package baekjoon.algorithm.two_pointer.g1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 좋다, 골드 4
// 투포인터 연습 문제, Do it 예제
public class Main {
    static int numArr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        numArr = new int[N];
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        Arrays.sort(numArr);
        for (int i = 0; i < N; i++) {
            int num = numArr[i];
            int start = 0;
            int end = N - 1;
            while (start < end) {
                if (start == i || end == i) {
                    if (start == i) {
                        start++;
                    } else {
                        end--;
                    }
                    continue;
                }
                if(numArr[start] + numArr[end] > num){
                    end--;
                } else if (numArr[start] + numArr[end] < num) {
                    start++;
                } else {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
