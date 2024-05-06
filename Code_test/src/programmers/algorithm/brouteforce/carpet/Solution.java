package programmers.algorithm.brouteforce.carpet;

class Solution {
    static int y;
    static int[] answer = new int[2];
    public int[] solution(int brown, int yellow) {

        int[][] carpet = new int[1][yellow];
        this.y = yellow;

        for(int i=0;i < y;i++){
            carpet[0][i] = i;
        }
        // for(int i=0;i<carpet[0].length;i++){
        //     System.out.print(carpet[0][i]);
        // }
        findCarpet(brown, carpet);

        return answer;
    }
    static void findCarpet(int brown, int[][] carpet){
        // for(int i=0;i<carpet[0].length;i++){
        //     System.out.print(carpet[0][i]);
        // }
        // 1. 재귀 탈출 조건(yellow로 만든 배열을 감쌀 수 있다면 탈출)
        // System.out.print(carpet[0].length * 2 + (carpet.length + 2) * 2);
        if(carpet[0].length * 2 + (carpet.length + 2) * 2 == brown){
            answer[0] = carpet[0].length + 2;
            answer[1] = carpet.length + 2;
            return;
        }
        // 2. yellow로 배열 만들어 재귀
        int tmpHeight = carpet.length + 1;
        while(y % tmpHeight != 0) tmpHeight++;
        int tmpWidth = y / tmpHeight;
        int[][] tmpCarpet = new int[tmpHeight][tmpWidth];
        for(int i=0;i<tmpHeight;i++){
            for(int j=0;j<tmpWidth;j++){
                tmpCarpet[i][j] = 1;
            }
        }
        findCarpet(brown, tmpCarpet);
    }
}