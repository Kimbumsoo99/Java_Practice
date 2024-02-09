package baekjoon.algorithm.lis.s11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();
        int ret = 0;
        list.add(arr[0]);
        for (int i = 1; i < N; i++) {
            if (arr[i] > list.get(ret)) {
                list.add(arr[i]);
                ret = list.size() - 1;
            }
            int pos = binarySearch(list, 0, ret, arr[i]);
            list.set(pos, arr[i]);
            System.out.println(arr[i] + " " + list.toString());
        }
        System.out.println(ret + 1);
    }

    static int binarySearch(ArrayList<Integer> lis, int start, int end, int element) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (element > lis.get(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}
