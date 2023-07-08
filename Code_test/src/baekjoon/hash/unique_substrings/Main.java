package baekjoon.hash.unique_substrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static HashSet<String> set = new HashSet<>();

    public static void findString(String str){
        if(str.length() == 0) return;
        if(!set.contains(str)) set.add(str);
        findString(str.substring(0, str.length() - 1));
    }

    public static void solutionDoubleLoop(String str){
        String tmp = "";
        for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){
                tmp = str.substring(i, j+1);
                set.add(tmp);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
//        set.add(str);
//        for(int i=0;i<str.length();i++){
//            findString(str.substring(0, i));
//            findString(str.substring(i+1));
//        }
        solutionDoubleLoop(str);
        System.out.println(set.size());
    }
}
