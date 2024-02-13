package baekjoon.greedy.s2839;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int five = N / 5;
        int rem = N % 5;
        while (rem % 3 != 0 && five > 0) {
            rem += 5;
            five -= 1;
        }
        int answer = five + rem / 3;
        if (five == 0 && rem % 3 != 0)
            answer = -1;
        System.out.println(answer);
    }
}
