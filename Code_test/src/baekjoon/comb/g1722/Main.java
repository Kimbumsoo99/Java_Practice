package baekjoon.comb.g1722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[], answer[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 1; i < N+1; i++) {
            arr[i - 1] = i;
        }
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int mode = Integer.parseInt(st.nextToken());
        if (mode == 1) {
            count(Integer.parseInt(st.nextToken()));
        } else {
            answer = new int[N];
            for (int i = 0; i < N; i++) {
                answer[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(equalsArrFind(answer));
        }
    }

    static int equalsArrFind(int[] answer) {
        int cnt = 1;
        do {
            boolean flag = true;
            for (int i = 0; i < N; i++) {
                if (answer[i] != arr[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return cnt;
            }
            cnt++;
        } while (np(arr));
        return cnt;
    }

    static void count(int cnt) {
        int l = 1;
        do {
            if (cnt > l++) {
                continue;
            }
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        } while (np(arr));
    }
    static boolean np(int p[]) {
        int i = N - 1;
        while (i > 0 && p[i - 1] > p[i]) {
            i--;
        }
        if (i == 0) {
            return false;
        }
        int j = N - 1;
        while (p[i - 1] > p[j]) {
            j--;
        }
        swap(p, i - 1, j);
        int k = N - 1;
        while (i < k) {
            swap(p, i++, k--);
        }
        return true;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
