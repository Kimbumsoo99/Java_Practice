package baekjoon.backtracking.silver.s10819;
import java.util.Scanner;

public class Main {
    static int max = 0;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            int tmp = sc.nextInt();
            arr[i] = tmp;
        }

        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            visit[i] = true;
            int[] newArr = new int[N];
            newArr[0] = arr[i];
            makeNumArr(N, newArr, 1);
            visit[i] = false;
        }
        System.out.println(max);
    }


    static void makeNumArr(int N, int[] makeArr, int depth) {
        if (depth == N) {
            max = Math.max(max, getSumValue(makeArr));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                makeArr[depth] = arr[i];
                makeNumArr(N, makeArr, depth + 1);
                visit[i] = false;
            }
        }

    }


    public static int getSumValue(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum += Math.abs(arr[i] - arr[i + 1]);
        }
        return sum;
    }
}
