package programmers.brouteforce.vowel_dictionary;

import java.util.*;

class Solution {
    static String[] vowel = {"A", "E", "I", "O", "U"};
    static ArrayList<String> str = new ArrayList<>();
    static HashMap<String, Integer> map = new HashMap<>();
    public int solution(String word) {
        int answer = 0;
        int length = 5;
        recursive("");
        Collections.sort(str, (o1, o2) -> o1.compareTo(o2));
        answer = str.indexOf(word) + 1;
        return answer;
    }
    static void recursive(String dict){
        if(!dict.equals("") && !map.containsKey(dict)){
            map.put(dict, 0);
            str.add(dict);
        }
        for(int i=0;i<5;i++){
            if(dict.length() < 5)
                recursive(dict + vowel[i]);
        }
    }
}