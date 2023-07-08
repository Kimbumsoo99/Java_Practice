package baekjoon.sort.age_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

    public static class People{
        int age;
        String name;

        People(int age, String name){
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<People> list = new ArrayList<>();
        StringTokenizer st;
        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            list.add(new People(Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        Collections.sort(list, new Comparator<People>(){
            @Override
            public int compare(People o1, People o2){
                return o1.age - o2.age;
            }
        });

        Iterator<People> it = list.iterator();
        while (it.hasNext()){
            People tmp = it.next();
            System.out.println(tmp.age + " " + tmp.name);
        }
    }

}
