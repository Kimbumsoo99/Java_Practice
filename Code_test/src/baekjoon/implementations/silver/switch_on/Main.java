package baekjoon.implementations.silver.switch_on;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] switchBtn;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        switchBtn = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            switchBtn[i] = Integer.parseInt(st.nextToken());
        }
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());
            if (sex == 1) {
                manSolution(location, N);
            }else {
                womenSolution(location - 1, N);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < switchBtn.length; i++) {
            if (i % 20 == 0 && i != 0) {
                sb.append("\n");
            }
            sb.append(switchBtn[i]).append(" ");
        }
        System.out.println(sb);
    }

    static void draw(){
        for (int i = 0; i < switchBtn.length; i++) {
            System.out.print(switchBtn[i] + " ");
        }
    }
    static void manSolution(int l, int N){
        int num = l;
        for (int i = 1; l * i <= N; i++) {
            num = l * i;
            switchBtn[num - 1] = switchBtn[num - 1] == 0 ? 1 : 0;
        }
    }
    static void womenSolution(int l, int N){
        switchBtn[l] = switchBtn[l] == 0 ? 1 : 0;
        int idx = 1;
        while (l - idx >= 0 && l + idx < N && switchBtn[l - idx] == switchBtn[l + idx]) {
            switchBtn[l - idx] = switchBtn[l - idx] == 0 ? 1 : 0;
            switchBtn[l + idx] = switchBtn[l + idx] == 0 ? 1 : 0;
            idx++;
        }
    }
}
