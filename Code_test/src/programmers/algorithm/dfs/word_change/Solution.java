package programmers.algorithm.dfs.word_change;

import java.util.ArrayList;

class Solution {
    static int answer = Integer.MAX_VALUE;
    static boolean visit[];
    static ArrayList<String> list = new ArrayList<>();
    public int solution(String begin, String target, String[] words) {
        for(String word:words){
            // System.out.println(word);
            list.add(word);
        }
        visit = new boolean[words.length];
        dfs(begin, target, words, 0);
        if(answer == Integer.MAX_VALUE){
            return 0;
        }

        return answer;
    }

    static void dfs(String current, String target, String[] words, int count){
        // 중지 조건
//        System.out.println(current + " " + target);
        if(current.equals(target)){
            answer = Math.min(answer, count);
            return;
        }

        // 반복
        for(int i=0;i<current.length();i++){
            for(int j='a';j<='z';j++){
                String tmp = current.substring(0, i) + (char) j + current.substring(i+1);
                // System.out.println(tmp + " " + list.contains(tmp));
                if(list.contains(tmp)){
                    int k = list.indexOf(tmp);
                    // System.out.println(k);
                    if(!visit[k]){
                        visit[k] = true;
                        dfs(tmp, target, words, count + 1);
                        visit[k] = false;
                    }
                }
                // for(int k=0;k<words.length;k++){
                //     // System.out.println(words[k] + " " + tmp);
                //     if(words[k].equals(tmp)){
                //         visit[k] = true;
                //         dfs(tmp, target, words, count + 1);
                //         visit[k] = false;
                //     }
                // }
            }
        }
    }

    public static void main(String[] args) {
        Solution s =new Solution();
        System.out.println(s.solution("hit", "cog",
            new String[]{"hat", "hot", "dat", "dot", "cat", "dog", "cot", "cog"}));
        System.out.println();
    }
}
