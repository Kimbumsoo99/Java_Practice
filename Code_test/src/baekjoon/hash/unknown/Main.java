package baekjoon.hash.unknown;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<String> peopleList = new ArrayList<>();
        HashSet<String> notHearPeople = new HashSet<>();
        HashSet<String> notSeePeople = new HashSet<>();

        for(int i=0;i<N;i++){
            String tmp = br.readLine();
            peopleList.add(tmp);
            notHearPeople.add(tmp);
        }
        for(int i=0;i<M;i++){
            String tmp = br.readLine();
            peopleList.add(tmp);
            notSeePeople.add(tmp);
        }
        ArrayList<String> notHSPeople = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for(String people:peopleList){
            if(notHSPeople.contains(people)) continue;
            else if(notSeePeople.contains(people) && notHearPeople.contains(people))
                notHSPeople.add(people);
        }
        sb.append(notHSPeople.size()).append("\n");
        Collections.sort(notHSPeople);
        Iterator<String> it = notHSPeople.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append("\n");
        }
        System.out.println(sb.toString());
    }

}
