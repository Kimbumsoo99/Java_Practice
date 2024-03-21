package programmers.implementation.kakao.코딩테스트_공부;

import java.util.*;

class Solution {
    static final int INF = 987654321;
    public int solution(int alp, int cop, int[][] problems) {
        int[][] problems2 = new int[problems.length + 2][5];
        int maxAlp = alp;
        int maxCop = cop;

        for(int i=0;i<problems.length;i++){
            maxAlp = Math.max(maxAlp, problems[i][0]);
            maxCop = Math.max(maxCop, problems[i][1]);
        }

        int[][] answer = new int[maxAlp+1][maxCop+1];

        for(int i=alp;i<=maxAlp;i++){
            Arrays.fill(answer[i], INF);
        }

        answer[alp][cop] = 0;
        for(int i=alp;i<=maxAlp;i++){
            for(int j=cop;j<=maxCop;j++){
                if(i < maxAlp) answer[i+1][j] = Math.min(answer[i+1][j], answer[i][j] + 1);
                if(j < maxCop) answer[i][j+1] = Math.min(answer[i][j+1], answer[i][j] + 1);

                for(int[] problem : problems){
                    if(problem[0] <= i && problem[1] <= j){
                        int nAlp = Math.min(problem[2] + i, maxAlp);
                        int nCop = Math.min(problem[3] + j, maxCop);
                        answer[nAlp][nCop] = Math.min(answer[nAlp][nCop], answer[i][j] + problem[4]);
                    }
                }
            }
        }

        /*for(int i=alp;i<=maxAlp;i++){
            for(int j=cop;j<=maxCop;j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }*/

        return answer[maxAlp][maxCop];
    }
}