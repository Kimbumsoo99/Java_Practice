package programmers.hash.lotto;

import java.util.*;
// 로또의 최고 순위와 최저 순위
// 2021 Dev-Matching:웹 백엔드 개발자(상반기) 문제
// level 1
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for(int w : win_nums){
            set.add(w);
        }
        int zeroCount = 0;
        int lottoCount = 0;
        for(int l : lottos){
            if(l == 0) zeroCount++;
            if(set.contains(l)) lottoCount++;
        }
        answer[0] = 7 - (lottoCount + zeroCount);
        answer[1] = 7 - lottoCount;

        for(int i=0;i<2;i++){
            if(answer[i] > 6){
                answer[i] = 6;
            }
        }


        return answer;
    }
}
