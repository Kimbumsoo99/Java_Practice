package baekjoon.sort.point_alignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main();
        int N = sc.nextInt();
        ArrayList<Point> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(m.new Point(x, y));
        }
        Collections.sort(list, Comparator.comparingInt((Point p) -> p.x).thenComparingInt(p -> p.y));
        for(Point point : list){
            System.out.println(point.x + " " + point.y);
        }
    }

}
