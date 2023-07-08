package baekjoon.sort.word_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<String> list = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            if(!list.contains(word))
                list.add(word);
        }

//        System.out.println(list.toString());
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                if(o1.length() == o2.length())
                    for (int i = 0;i<o1.length();i++) {
                        if(o1.charAt(i) != o2.charAt(i))
                            return o1.charAt(i) - o2.charAt(i);
                    }
                return o1.length() - o2.length();
            }
        });
        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
