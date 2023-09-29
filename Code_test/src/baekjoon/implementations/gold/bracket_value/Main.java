package baekjoon.implementations.gold.bracket_value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Stack<Character> stack = new Stack<>();
    static Stack<Integer> number = new Stack<>();
    static HashMap<Character, Integer> dict = new HashMap<>();
    static HashMap<Character, Character> close = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        dict.put('(', 2);
        dict.put('[', 3);
        close.put(')', '(');
        close.put(']', '[');
        for (int i = 0; i < str.length(); i++) {
            Character e = str.charAt(i);
//            System.out.println(i + 1 + " " + number.toString() + " " + stack.toString() + " Element:" + e);
            if (dict.containsKey(e)) {
                stack.push(e);
            } else if (close.containsKey(e)) {
                if (stack.isEmpty()) {
                    exitProgram(0);
                } else if (stack.peek() == 'N') {
                    int tmp = number.pop();
                    stack.pop(); // 'N'을 팝
                    if (stack.isEmpty()) {
                        exitProgram(0);
                    } else if (close.get(e) == stack.peek()) {
                        Character ch = stack.pop(); // '('를 팝
                        tmp = tmp * dict.get(ch);
                        while (!stack.isEmpty() && stack.peek() == 'N') {
                            tmp = tmp + number.pop();
                            stack.pop();
                        }
                        number.push(tmp);
                        stack.push('N');
                    } else {
                        exitProgram(0);
                    }
                } else if (stack.peek() == close.get(e)) {
                    Character tmp = stack.pop();
                    int num = dict.get(tmp);
                    while (!stack.isEmpty() && stack.peek() == 'N') {
                        num += number.pop();
                        stack.pop();
                    }
                    stack.push('N');
                    number.push(num);
                } else {
                    exitProgram(0);
                }
            }
        }
        Iterator<Integer> it = number.iterator();
        int answer = 0;
        while (it.hasNext()) {
            int tmp = it.next();
            answer += tmp;
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == 'N') {
                stack.pop();
            } else if (dict.containsKey(stack.peek())) {
                exitProgram(0);
            }
        }
        System.out.println(answer);
    }
    static void exitProgram(int ErrorINdex) {
        System.out.println(ErrorINdex);
        System.exit(0);
    }
}

