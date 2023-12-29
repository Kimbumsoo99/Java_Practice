package swea.d2.n1961;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            StringBuilder[] stringBuilders = new StringBuilder[N];
            for (int i = 0; i < N; i++) {
                stringBuilders[i] = new StringBuilder();
            }
            for (int k = 0; k < 3; k++) {
                int newArr[][] = new int[N][N];
                for (int i = 0; i < N; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = N - 1; j >= 0; j--) {
                        sb.append(arr[j][i]);
                    }
                    for (int j = 0; j < N; j++) {
                        newArr[i][j] = sb.charAt(j) - '0';
                    }
                    stringBuilders[i].append(sb).append(" ");
                }
//                for (int i = 0; i < N; i++) {
//                    for (int j = 0; j < N; j++) {
//                        System.out.print(newArr[i][j] + " ");
//                    }
//                    System.out.println();
//                }
                arr = newArr;
            }

            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
                System.out.println(stringBuilders[i]);
            }
        }
    }
}
