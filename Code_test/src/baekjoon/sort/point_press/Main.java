package baekjoon.sort.point_press;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static class Point{
        int index;
        int preX;
        int rank;

        Point(int preX, int index){
            this.index = index;
            this.preX = preX;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Point> list = new ArrayList<>();
        for(int i = 0;i<N;i++){
            list.add(new Point(Integer.parseInt(st.nextToken()), i));
        }
        Collections.sort(list, (o1, o2) -> o1.preX - o2.preX);

//        ArrayList<Point> minusList = new ArrayList<>();
//        ArrayList<Point> plusList = new ArrayList<>();
//
//        for(int i =0;i<N;i++){
//            if(list.get(i).preX < 0){
//                minusList.add(list.get(i));
//            }else{
//                plusList.add(list.get(i));
//            }
//        }
        int count = -1;
        for(int i=0;i<N;i++){
            if(i != 0 && list.get(i - 1).preX == list.get(i).preX){
                list.get(i).rank = count;
                continue;
            }
            list.get(i).rank = ++count;
        }
        Collections.sort(list, (o1, o2) -> o1.index - o2.index);
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<N;i++){
            sb.append(list.get(i).rank).append(" ");
        }
        System.out.println(sb.toString());
//        for(int i = 0;i<minusList.size();i++){
//            System.out.println(minusList.get(i).preX);
//        }
//        for(int i =0;i<plusList.size();i++){
//            System.out.println(plusList.get(i).preX);
//        }
    }

}
