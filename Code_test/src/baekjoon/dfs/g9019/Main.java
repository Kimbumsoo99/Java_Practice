package baekjoon.dfs.g9019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// DSLR, BFS 문제 (카테고리 봄)
public class Main {
    static boolean visit[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            visit = new boolean[10000];
            long cmd = bfs(A, B);
            char[] cmdStr = String.valueOf(cmd).toCharArray();
            for (char c : cmdStr) {
                if(c=='1') {
                    sb.append('D');
                }else if(c=='2') {
                    sb.append('S');
                }else if(c=='3') {
                    sb.append('L');
                }else {
                    sb.append('R');
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static long bfs(int A, int B) {
        ArrayDeque<long[]> dq = new ArrayDeque<>();
        dq.offer(new long[] {A, 1});
        dq.offer(new long[] {A, 2});
        dq.offer(new long[] {A, 3});
        dq.offer(new long[] {A, 4});
        visit[A] = true;

//        int count = 0;
        while(!dq.isEmpty()) {
//        while (count++ < 20){
            long[] tmp = dq.pollFirst();
            long next = tmp[0];

            // 연산
            next = getNext((int) next, (int) (tmp[1] % 10));
            if(next == B) {
                return tmp[1];
            }

            for (int i = 1; i < 5; i++) {
                if (!visit[(int) next]) {
                    dq.offer(new long[] {next, tmp[1] * 10 + i});
                }
            }
            if (!visit[(int) next]) {
                visit[(int) next] = true;
            }
        }
        return -1;
    }

    static int getNext(int value, int op){
        if (op == 1) {
            return operD(value);
        } else if (op == 2) {
            return operS(value);
        } else if (op == 3) {
            return operL(value);
        } else {
            return operR(value);
        }
    }

    static int operD(int value) {
        return value * 2 % 10000;
    }

    static int operS(int value) {
        return value - 1 == -1 ? 9999 : value - 1;
    }

    static int operL(int value) {
        int d1 = value / 1000; // 5
        value %= 1000; // 623
        int d2 = value / 100; // 6
        value %= 100; // 23
        int d3 = value / 10; // 2
        value %= 10; // 3
        int d4 = value;
        return d2 * 1000 + d3 * 100 + d4 * 10 + d1;
    }

    static int operR(int value){
        int d1 = value / 1000; // 5
        value %= 1000; // 623
        int d2 = value / 100; // 6
        value %= 100; // 23
        int d3 = value / 10; // 2
        value %= 10; // 3
        int d4 = value;
        return d4 * 1000 + d1 * 100 + d2 * 10 + d3;
    }
}