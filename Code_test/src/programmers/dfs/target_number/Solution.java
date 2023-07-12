package programmers.dfs.target_number;

class Solution {
    static int target;
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        this.target = target;
        dfs(numbers, 0, 0);
        return answer;
    }
    static void dfs(int[] numbers, int sum, int count){
        if(count == numbers.length){
            // System.out.println(sum);
            if(sum == target) answer++;
            return;
        }
        dfs(numbers, sum + numbers[count], count + 1);
        dfs(numbers, sum - numbers[count], count + 1);
    }
}