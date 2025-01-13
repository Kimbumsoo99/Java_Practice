package baekjoon.string.silver.s25178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[27];
        boolean flag = true;
        HashSet<Character> set = new HashSet<>();
        set.addAll(List.of('a', 'e', 'i', 'o', 'u'));

        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < N; i++) {
            cnt[A[i] - 'a']++;
            cnt[B[i] - 'a']--;
            if(!set.contains(A[i])) {
                sb1.append(A[i]);
            }
            if(!set.contains(B[i])) {
                sb2.append(B[i]);
            }
        }

        for (int i = 0; i < 27; i++) {
            if (cnt[i] != 0) {
                flag = false;
            }
        }

        if(A[0] != B[0] || A[A.length - 1] != B[B.length - 1]) {
            flag = false;
        }

        if (sb1.compareTo(sb2) != 0) {
            flag = false;
        }

        System.out.println(flag ? "YES" : "NO");
    }
}