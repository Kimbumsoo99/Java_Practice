package programmers.implementation.clean_desktop;

import java.util.*;

public class Solution {
    int Graph[][], N, M;
    int maxY, maxX, minY, minX;
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        N = wallpaper.length;
        M = wallpaper[0].length();
        maxY = maxX = Integer.MIN_VALUE;
        minY = minX = Integer.MAX_VALUE;
        Graph = new int[N][M];
        for(int i=0;i<N;i++){
            char[] arr = wallpaper[i].toCharArray();
            for(int j=0;j<M;j++){
                if(arr[j] == '.'){
                    Graph[i][j] = 0;
                }else{
                    Graph[i][j] = 1;
                    if(minY > i){
                        minY = i;
                    }
                    if(maxY < i+1){
                        maxY = i+1;
                    }
                    if(maxX < j+1){
                        maxX = j+1;
                    }
                    if(minX > j){
                        minX = j;
                    }
                }
            }
        }
        answer = new int[4];
        answer[0] = minY;
        answer[1] = minX;
        answer[2] = maxY;
        answer[3] = maxX;
        return answer;
    }
}
