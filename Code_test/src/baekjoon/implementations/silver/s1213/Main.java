package baekjoon.implementations.silver.s1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

// 1213번, 팰린드롬 만들기, 실버 III
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split("");
        HashMap<String, Integer> dict = new HashMap<>();
        ArrayList<String> priority = new ArrayList<>();
        for (String word : words) {
            if (!dict.containsKey(word)) {
                dict.put(word, 1);
                priority.add(word);
            } else {
                dict.put(word, dict.get(word) + 1);
            }
        }
        Collections.sort(priority);
        StringBuilder sb = new StringBuilder();
        boolean fail = false;
        while (!dict.isEmpty()) {
            if (dict.size() == 1 && dict.get(getOneWordDict(dict)) == 1) {
                break;
            }
            int idx = 0;
            String tmp = null;
            while (true) {
                if (idx >= priority.size()) {
                    System.out.println("I'm Sorry Hansoo");
                    System.exit(0);
                }
                tmp = priority.get(idx);
                if (dict.containsKey(tmp) && dict.get(tmp) > 1) {
                    break;
                } else {
                    idx++;
                }
            }
            sb.append(tmp);
            dict.put(tmp, dict.get(tmp) - 2);
            if (dict.get(tmp) == 0) {
                dict.remove(tmp);
            }
        }

        String tmp = getOneWordDict(dict);
        String answer;
        if (tmp.equals("null")) {
            answer = sb.toString() + sb.reverse().toString();
        } else {
            answer = sb.toString() + tmp + sb.reverse().toString();
        }
        System.out.println(answer);
    }

    static String getOneWordDict(HashMap<String, Integer> dict) {
        Iterator<String> it = dict.keySet().iterator();
        if (it.hasNext()) {
            return it.next();
        }
        else {
            return "null";
        }
    }

}
