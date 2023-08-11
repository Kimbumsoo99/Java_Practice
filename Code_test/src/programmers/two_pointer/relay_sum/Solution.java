package programmers.two_pointer.relay_sum;

// 직접 푼 문제라고 보기 어려움
// https://school.programmers.co.kr/learn/courses/30/lessons/178870
// 연속된 부분 수열의 합 level 2
class Solution {
    public int[] solution(int[] sequence, int k) {

        int N = sequence.length;
        int left = 0, right = N;
        int sum = 0;
        for(int L = 0, R = 0; L < N; L++) {
            while(R < N && sum < k) {
                // System.out.print(sequence[R] + " ");
                sum += sequence[R++];
            }

            if(sum == k) {
                int range = R - L - 1;
                if((right - left) > range) {
                    left = L;
                    right = R - 1;
                }
            }

            // System.out.println(" LEFT " + sequence[L] + " " + sum);
            sum -= sequence[L];
        }

        int[] answer = {left, right};

        return answer;
    }
}