package baekjoon.stack.stack_sequence;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Why {
// 오류났던 코드

    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            list.add(sc.nextInt());
        }
        int tmp = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
//            System.out.println(tmp + " " + list.get(i));
            if (tmp <= list.get(i)) {
                sb.append("+").append("\n");
                stack.push(tmp++);
                i--;
            } else if (stack.peek() == list.get(i)) {
                sb.append("-").append("\n");
                stack.pop();
            }
        }
        if (stack.empty())
            System.out.println(sb);
        else {
            System.out.println("NO");
        }
    }
}

