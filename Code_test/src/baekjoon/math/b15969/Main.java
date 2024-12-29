package baekjoon.math.b15969;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	List<Integer> num = new ArrayList<Integer>();
    	
    	for(int i=0;i<n;i++) {
    		num.add(sc.nextInt());
    	}
    	Collections.sort(num);
    	System.out.println(num.get(n - 1) - num.get(0));
   }
}
