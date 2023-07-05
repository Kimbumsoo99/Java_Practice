package programmers.hash.ponkemon;
import java.util.HashSet;
class Solution {
    public static int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> hi = new HashSet<>();
        for(int num:nums){
            hi.add(num);
        }

        answer = hi.size();
        if(answer < (int)(nums.length / 2)) return answer;
        else answer = (int)(nums.length / 2);
        return answer;
    }

    public static void main(String[] args){
        int[] nums = {3,1,2,3};
        System.out.print(solution(nums));
    }
}
