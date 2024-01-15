package baekjoon.string.silver.s5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int S = Integer.parseInt(br.readLine());
        String tmp = br.readLine();
        int i = 0;
        int count = 0;
        int answer = 0;
        while(i<S-2) {
            if(tmp.substring(i, i+3).equals("IOI")) {
                i+=2;
                count++;
                if(count==N) {
                    answer++;
                    count--;
                }
            }else {
                i++;
                count=0;
            }
        }
        System.out.println(answer);
    }
}
