package baekjoon.dp.s10826;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static BigInteger fib[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        fib = new BigInteger[10001];
        fib[0] = new BigInteger("0");
        fib[1] = new BigInteger("1");
        for (int i = 2; i < 10001; i++) {
            fib[i] = fib[i - 1].add(fib[i - 2]);
        }
        System.out.println(fib[N]);
    }
}
