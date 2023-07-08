package baekjoon.stack.balanced_world;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Character> stack = new Stack<>();

    public static boolean isGood(String str){
        int index = 0;
        char word = str.charAt(index++);
        while (word != '.'){
//            System.out.print(word);
            if(word == '[' || word == '('){
                stack.push(word);
            } else if (word == ']') {
                if(stack.empty() || '[' != stack.pop()){
                    return false;
                }
            } else if (word == ')') {
                if (stack.empty() || '(' != stack.pop()) {
                    return false;
                }
            }
            word = str.charAt(index++);
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        while (!str.equals(".")){
            sb.append(isGood(str)?"yes":"no").append("\n");
            str = br.readLine();
            stack.clear();
        }
        System.out.println(sb);
    }
}
