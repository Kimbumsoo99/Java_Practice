package baekjoon.algorithm.binary_search.s1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            list.add(tmp);
        }
        Collections.sort(list);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(findRecur(tmp, 0, N-1)) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb);
    }

    static boolean find(int key, int N) {
        int start = 0;
        int end = N - 1;
        while(start <= end) {
            int mid = (start + end) / 2;

            if(key < list.get(mid)) {
                end = mid - 1;
            }else if(key > list.get(mid)) {
                start = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }

    static boolean findRecur(int findNum, int start, int end) {
        if(start > end) return false;
        int mid = (start+end) / 2;

        if(list.get(mid) < findNum) {
            return findRecur(findNum, mid+1, end);
        }else if(list.get(mid) > findNum) {
            return findRecur(findNum, start, mid-1);
        }else {
            return true;
        }

    }
}
