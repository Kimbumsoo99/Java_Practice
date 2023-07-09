package baekjoon.sort.english_learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> wordDict = new ArrayList<>();
        for(int i=0;i<N;i++){
            String word = br.readLine();
            if (word.length() < M) continue;
            if(!map.containsKey(word)) wordDict.add(word);
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        Collections.sort(wordDict, (o1, o2) -> {
            if(map.get(o1) == map.get(o2)){
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
            return map.get(o2) - map.get(o1);
        });
        Iterator<String> it = wordDict.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next()).append("\n");
        }
        System.out.println(sb);

    }

}
