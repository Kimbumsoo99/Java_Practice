package baekjoon.implementations.silver.base_conversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int[] number = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = N - 1; i >= 0; i--) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int aToTenNumber = 0;
        for (int i = 0; i < N; i++) {
            aToTenNumber += (Math.pow(A, i) * number[i]);
        }

        int tenToBNumber = aToTenNumber;
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (tenToBNumber != 0) {
            list.add(tenToBNumber % B);
            tenToBNumber /= B;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
