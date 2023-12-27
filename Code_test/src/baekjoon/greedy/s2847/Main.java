package baekjoon.greedy.s2847;
// Java_Coding_Test_Practice 1227
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            num[i] = tmp;
        }

        int answer = 0;
        for (int i = N - 2; i >= 0; i--) {
            if (num[i] >= num[i + 1]) {
                answer += (num[i] - (num[i + 1] - 1));
                num[i] = num[i + 1] - 1;
            }
        }
        System.out.println(answer);
    }
}
