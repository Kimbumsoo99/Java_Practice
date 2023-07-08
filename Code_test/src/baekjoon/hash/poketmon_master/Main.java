package baekjoon.hash.poketmon_master;

import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> numberMap = new HashMap<>();
        HashMap<Integer, String> poketMap = new HashMap<>();

        for(int i=0;i<N;i++){
            String tmp = br.readLine();
            poketMap.put(i+1, tmp);
            numberMap.put(tmp, i+1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            Object tmp = br.readLine();
            if (numberMap.containsKey(tmp)) {
                sb.append(numberMap.get(tmp)).append("\n");
            }else{
                sb.append(poketMap.get(Integer.parseInt((String) tmp))).append("\n");
            }
        }
        System.out.println(sb.toString());

    }

}
