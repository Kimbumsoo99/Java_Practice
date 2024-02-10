package baekjoon.algorithm.two_pointer.s3273;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int X = Integer.parseInt(br.readLine());
        Collections.sort(list);
        int start = 0;
        int end = N - 1;
        int count = 0;
        while (start != end) {
            int sum = list.get(start) + list.get(end);
            if (sum >= X) {
                if (sum == X) {
                    count++;
                }
                end--;
            } else {
                start++;
            }
        }
        System.out.println(count);
    }
}
