package baekjoon.implementations.bronze.b28431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;

//브론즈 IV, 양말 짝 맞추기
public class Main {

    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            int N = Integer.parseInt(br.readLine());
            if (set.contains(N)) {
                set.remove(N);
            } else {
                set.add(N);
            }
        }
        Iterator<Integer> it = set.iterator();
        System.out.println(it.next());
    }

}
