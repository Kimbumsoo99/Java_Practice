package sort.count;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static int max = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        int[] count = new int[max + 1];
        int[] countSum = new int[max + 1];
        for(int i =0; i<N;i++){
            int tmp =Integer.parseInt(br.readLine());
            list.add(tmp);
            count[tmp] ++;
        }
        countSum[0] = count[0];
        for(int i=1;i<max+1;i++){
            countSum[i] = countSum[i-1] + count[i];
        }
        int[] result = new int[N + 1];
        for(int i=0;i<10;i++){
//            System.out.println(countSum[i]);
        }
        for(int i = N-1;i>-1;i--){
//            System.out.println(list.get(i)+" "+countSum[list.get(i)]);
            result[countSum[list.get(i)] - 1] = list.get(i);
            countSum[list.get(i)]--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}

