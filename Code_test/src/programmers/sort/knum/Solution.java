package programmers.sort.knum;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int a = 0;
        for(int[] command: commands){
            int i = command[0] - 1;
            int j = command[1];
            int k = command[2];

            int[] tmp = new int[j-i];
            for(int x=0;x<tmp.length;x++){
                tmp[x] = array[i++];
            }
            Arrays.sort(tmp);
            answer[a++] = tmp[k-1];

        }

        return answer;
    }
}