package baekjoon.algorithm.lis.g12015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int arr[], N, size;
    static ArrayList<Integer> dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        dp = new ArrayList<>();
        arr = new int[N];
        size = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int cur = arr[i];
            binarySearch(cur);
        }
        System.out.println(dp.size());
    }

    static void binarySearch(int val){
        if(dp.size() == 0){
            dp.add(val);
            return;
        }

        int start = 0;
        int end = dp.size();
        while (start < end) {
            int mid = (start + end) / 2; // 2(3번째) 1부터 확인
//            System.out.println(mid);
            if (dp.get(mid) < val) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (start == dp.size()) {
            dp.add(val);
        } else {
            dp.set(start, val);
        }
//        System.out.println(dp);
    }

}
