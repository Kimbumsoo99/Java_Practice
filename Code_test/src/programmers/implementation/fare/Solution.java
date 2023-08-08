package programmers.implementation.fare;

// 부족한 금액 계산하기
// level 1
public class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        for(int i=1;i<=count;i++){
            answer += (long) price * i;
        }
        if(answer < money) return 0;
        return answer - money;
    }
}
