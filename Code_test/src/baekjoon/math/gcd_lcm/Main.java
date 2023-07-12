package baekjoon.math.gcd_lcm;

import java.util.Scanner;

public class Main {
    static int recursiveGCD(int a, int b) {
        // GCD -> Greastest Common Divisor -> 최대공약수
        // A의 약수들을 모두 구하고, B의 약수들을 모두 구해 공통된 약수의 곱
        // 위 방식은 오래 걸림

        // 유클리드 호제법 (Euclidean algorithm) 互(서로 호), 除(나눌 제, 뺄 제) 즉 서로 나눈다는 의미로 호제
        // r = a mod b 이라고 한다. (r 은 a에 b를 나눈 나머지를 의미)
        // a 와 b의 최대공약수를 (a, b)라고 할 때 (a, b)의 최대공약수는 (b, r)의 최대공약수와 같다.
        // https://st-lab.tistory.com/154 <- 자세한 설명
        if(b == 0){
            return a;
        }
//        System.out.println(a + " " + b);
        int answer = recursiveGCD(b, a % b);
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
//        int small = Math.min(N, M);
//        int gcd = 1;
//        for (int i = small; i > 0; i--) {
//            if (N % i == 0 && M % i == 0) {
//                gcd = i;
//                sb.append(gcd).append("\n");
//                break;
//            }
//        }
        // 두 수의 곱 / 최대 공약수 == 최소공배수
        int gcd = recursiveGCD(Math.max(N, M), Math.min(N, M));
        sb.append(gcd).append("\n");
        int lcm = N * M / gcd;

        sb.append(lcm).append("\n");
        System.out.println(sb);
    }
}
