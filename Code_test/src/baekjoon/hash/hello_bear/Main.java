package baekjoon.hash.hello_bear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<N;i++){
            String str = br.readLine();
            if(str.equals("ENTER")){
                set.clear();
            } else {
                if(!set.contains(str)) map.put(str, map.getOrDefault(str, 0) + 1);
                set.add(str);
            }
        }
        Iterator<Integer> it = map.values().iterator();

        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (it.hasNext()) {
            count += it.next();
        }
        sb.append(count);
        System.out.println(sb);

    }

}
