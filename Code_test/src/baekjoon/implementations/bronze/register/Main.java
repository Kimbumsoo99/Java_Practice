package baekjoon.implementations.bronze.register;

import java.io.*;
import java.util.*;
// 저항, 브 II, 1076번 문제
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();

        ArrayList<String> color = new ArrayList<>();
        color.add("black");
        color.add("brown");
        color.add("red");
        color.add("orange");
        color.add("yellow");
        color.add("green");
        color.add("blue");
        color.add("violet");
        color.add("grey");
        color.add("white");

        long answer = 0L;
        answer += color.indexOf(first)*10;
        answer += color.indexOf(second);
        answer *= Math.pow(10, color.indexOf(third));

        System.out.println(answer);
    }
}