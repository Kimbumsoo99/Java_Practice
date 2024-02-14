package baekjoon.data_structure.stack.g16120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        if (arr.length < 4 && arr.length > 1) {
            System.out.println("NP");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
//			System.out.println(i + " : " + arr[i] + " " + stack);
            if (arr[i] == 'P') {
                stack.push('P');
            } else {
                // A일때 스택안에 P가 두개있나?
                for (int j = 0; j < 2; j++) {
                    try {
                        char c = stack.pop();
                    } catch (Exception e) {
                        flag = false;
                    }
                }
                // A일 때 내 뒷 문자열이 P인가?
                if (i + 1 == arr.length || arr[i + 1] != 'P') {
                    flag = false;
                } else {
                    i++;
                    stack.push('P');
                }
            }
            if (!flag)
                break;
        }

        if (flag && stack.size() == 1)
            System.out.println("PPAP");
        else
            System.out.println("NP");
    }
}
