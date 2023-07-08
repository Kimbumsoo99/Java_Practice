package baekjoon.hash.sym_diff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

//    public static void firstSolution(int N, int M){
//
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) setA.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) setB.add(Integer.parseInt(st.nextToken()));

        int count = 0;

        Iterator<Integer> itA = setA.iterator();
        while (itA.hasNext()) {
            if(!setB.contains(itA.next())) count++;
        }
        Iterator<Integer> itB = setB.iterator();
        while (itB.hasNext()) {
            if(!setA.contains(itB.next())) count++;
        }
        System.out.println(count);

    }

}
