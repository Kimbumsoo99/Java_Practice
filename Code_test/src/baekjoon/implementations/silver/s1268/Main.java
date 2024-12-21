package baekjoon.implementations.silver.s1268;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] studentClass = new int[num][5];
        for(int i = 0; i < num; i++){
            for(int j = 0; j <5 ; j++){
                studentClass[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        int leader = 0;
        for(int i = 0; i<num; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = 0; j<5; j++){
                for(int k = 0; k<num; k++){
                    if(studentClass[i][j] == studentClass[k][j]
                            && i!=k){
                        set.add(k);
                    }
                }
            }
            if(set.size()>max) {
                leader = i;
                max = set.size();
            }
        }
        System.out.println(leader + 1);
    }
}