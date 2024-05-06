package programmers.data_structure.hash.clothes;
import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] arr:clothes){
            map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
        }
        // System.out.println(map);
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()){
            // System.out.println(it.next());
            answer *= (map.get(it.next()) + 1);
        }
        return answer - 1;
    }
}