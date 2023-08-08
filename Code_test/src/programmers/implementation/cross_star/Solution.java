package programmers.implementation.cross_star;

// 두 직선
// Ax + By + E = 0
// Cx + Dy + F = 0

// 교점
// x = (BF - ED) / (AD - BC);
// y = (EC - AF) / (AD - BC);

import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        HashSet<Long[]> set = new HashSet<>();
        long minX, minY;
        minX = minY = Long.MAX_VALUE;
        long maxX, maxY;
        maxX = maxY = Long.MIN_VALUE;
        for(int i=0;i<line.length;i++){
            for(int j=i+1;j<line.length;j++){
                long A = line[i][0];
                long B = line[i][1];
                long E = line[i][2];
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];
                if(A * D - B * C == 0) continue;

                double x = (double) (B * F - E * D) / (A * D - B * C);
                double y = (double) (E * C - A * F) / (A * D - B * C);
                if(isNum(x) && isNum(y)){
                    set.add(new Long[]{(long) y, (long) x});
                    if(minX > (long) x) minX = (long) x;
                    if(minY > (long) y) minY = (long) y;
                    if(maxX < (long) x) maxX = (long) x;
                    if(maxY < (long) y) maxY = (long) y;
                }
            }
        }
        long length = maxY - minY + 1;
        System.out.println(length);
        answer = new String[(int) length];
        int idx = 0;
        for(long i=maxY;i>=minY;i--){
            answer[idx] = "";
            for(long j=minX;j<=maxX;j++){
                if(isContains(set, i, j)) answer[idx] += "*";
                else answer[idx] += ".";
            }
            idx++;
        }

        return answer;
    }

    static boolean isContains(HashSet<Long[]> set, long i, long j){
        for(Long[] tmp : set){
            if(tmp[0] == i && tmp[1] == j){
                // System.out.println("x :" + tmp[0] + "\ty :" + tmp[1]);
                return true;
            }
        }
        return false;
    }

    static boolean isNum(double n){
        if(n - (long) n == 0) return true;
        return false;
    }
}
