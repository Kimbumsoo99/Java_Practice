package baekjoon.data_structure.stack.stack_sequence;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
//        ArrayList<Integer> list = new ArrayList<>();
//        for(int i=0;i<N;i++){
//            list.add(sc.nextInt());
//        }
        int tmp = 1;
        StringBuilder sb = new StringBuilder();
        boolean result = true;
        for(int i=0;i<N;i++){
//            System.out.print(tmp + " " + list.get(i)+" ");
//            if (!stack.empty()) {
//                System.out.println(stack.peek());
//            } else {
//                System.out.println();
//            }
            int num = sc.nextInt();
            while (tmp <= num) {
                sb.append("+").append("\n");
                stack.push(tmp++);
            } if (stack.peek() == num) {
//                System.out.println("pop");
                stack.pop();
                sb.append("-").append("\n");
            }
//            else if (stack.peek() != num) {
////                sb = new StringBuilder();
////                sb.append("NO");
//                result = false;
//                break;
//            }
        }
        if (stack.empty())
            System.out.println(sb);
        else {
            System.out.println("NO");
        }
    }
}
