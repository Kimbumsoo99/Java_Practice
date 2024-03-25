package baekjoon.string.silver.s1706;

import java.util.*;
import java.io.*;

public class Main {
    static char[][] reverseMap;
    static String[] map;
    static ArrayList<String> list = new ArrayList<>();
    static int R, C;
    static String answer = "zzzzzzzzzzzzzzzzzzzzzzz";
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        reverseMap = new char[C][R];
        map = new String[R];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine();
        }
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                reverseMap[i][j] = map[j].charAt(i);
            }
        }
        rowString();
        colString();
        System.out.println(answer);
    }

    static void rowString(){
        int idx = 0;
        while(idx++ < R){
            String[] tmp = map[idx-1].split("#");
            for(String str : tmp){
                if(str.length() > 1 && answer.compareTo(str) > 0){
                    answer = str;
                }
            }
        }
    }

    static void colString(){
        int idx = 0;
        while(idx++ < C){
            String[] tmp = String.valueOf(reverseMap[idx - 1]).split("#");
            for(String str : tmp){
                if(str.length() > 1 && answer.compareTo(str) > 0){
                    answer = str;
                }
            }
        }
    }

}
