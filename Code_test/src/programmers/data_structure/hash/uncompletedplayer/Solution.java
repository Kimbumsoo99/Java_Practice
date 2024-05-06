package programmers.data_structure.hash.uncompletedplayer;
import java.util.HashMap;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();
        String answer = "";

        for(String name:participant){
            if(hm.get(name) == null){
                hm.put(name, 1);
            }else{
                hm.put(name, hm.get(name) + 1);
            }
            // hm.put(name, hm.getOrDefault(name, 0) + 1);
        }
        // System.out.println(hm);
        for(String name: completion)
            hm.put(name, hm.get(name) - 1);

        for(String name: hm.keySet()){
            if(hm.get(name) != 0){
                answer = name;
                break;
            }
        }
        return answer;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(sol.solution(participant, completion));

    }

}
