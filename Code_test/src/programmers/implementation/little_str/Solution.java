import java.util.*;
class Solution {
    static ArrayList<Long> list = new ArrayList<>();
    public int solution(String t, String p) {
        int answer = 0;
        int length = p.length();
        for(int i=0;i<t.length() - length + 1;i++){
            String tmp = t.substring(i, i+length);
            list.add(Long.valueOf(tmp));
        }
        long pNum = Long.valueOf(p);
        for(Long n : list){
            // System.out.println(n + " " + p);
            
            if(pNum >= n) {
                answer++;
            }
        }
        return answer;
    }
}
