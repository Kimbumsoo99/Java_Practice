package baekjoon.implementations.gold.bracket_value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Stack<Character> stack = new Stack<>();
    static Stack<Integer> number = new Stack<>();
    static HashMap<Character, Integer> open = new HashMap<>();
    static HashMap<Character, Character> close = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        open.put('(', 2);
        open.put('[', 3);
        close.put(')', '(');
        close.put(']', '[');
        for (int i = 0; i < str.length(); i++) {
            Character e = str.charAt(i);
//            System.out.println(i + 1 + " " + number.toString() + " " + stack.toString() + " Element:" + e);
            if (open.containsKey(e)) {
                stack.push(e);
            } else if (close.containsKey(e)) { // 닫는 괄호
                if (stack.isEmpty()) {
                    exitProgram(0);
                } else if (stack.peek() == 'N') { // 닫는 괄호이후 숫자가 나왔다면,
                    int tmp = number.pop();
                    stack.pop(); // 'N'을 팝
                    if (stack.isEmpty()) {
                        exitProgram(0);
                    } else if (close.get(e) == stack.peek()) { // 괄호가 맞는다면, 숫자를 곱한다.
                        Character ch = stack.pop(); // '('를 팝
                        tmp = tmp * open.get(ch);
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
                    int num = open.get(tmp);
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
            } else if (open.containsKey(stack.peek())) {
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

