package baekjoon.data_structure.stack.s30892;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long size = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        for (int i = 0; i < N; i++) {
            stack.push(list.get(i));
        }
        Stack<Integer> tmp = new Stack<>();

        while (K > 0 && !stack.isEmpty()) {
            int shark = stack.pop();
            if (shark < size) { // 먹는 경우
                size += shark;
                K--;
                while (!tmp.isEmpty()) {
                    stack.push(tmp.pop());
                }
            } else {
                tmp.push(shark);
            }
        }
        System.out.println(size);
    }
}
