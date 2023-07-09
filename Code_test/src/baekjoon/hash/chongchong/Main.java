package baekjoon.hash.chongchong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        StringTokenizer st;
        boolean chongChong = false;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            if(A.equals("ChongChong") || B.equals("ChongChong")){
                set.add(A);
                set.add(B);
            } else if (set.contains(A) || set.contains(B)) {
                set.add(A);
                set.add(B);
            }
        }
        System.out.println(set.size());

    }

}
