package baekjoon.dfs.fibonacci5;

public class Solution {
    int count = 0;
    int index;
    static Integer[] dp;
    public static int fib1(int num){
        if(num < 2) return num;

        return fib1(num - 1) + fib1(num - 2);
    }

    public static int fib3(int num){
        if(dp[num] == -1) dp[num] = fib3(num-1) + fib3(num-2);


        return dp[num];
    }

    // fib2 는 직접 생각한 피보나치 재귀 풀이
    public int fib2(int fn_0, int fn_1){
        if(count == index - 2){
            return fn_0 + fn_1;
        }
        count++;
        return fib2(fn_1, fn_0 + fn_1);
    }
    public int solution(int index){
        int answer = 0;
        this.index = index;
        answer = fib2(0,1);
        System.out.println(fib1(10));
        dp = new Integer[100];
        for(int i = 0;i<100;i++){
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 1;
        System.out.println(fib3(10));

        return answer;
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.solution(10));

    }

}
