package baekjoon.implementations.gold.string_boom;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String boom = br.readLine();

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < input.length(); i++) {
            st.push(input.charAt(i));

            // 스택의 사이즈가 폭발 문자열의 길이보다 길다면
            // 폭발 문자열이 존재할 수 있다.
            if(st.size() >= boom.length()) {
                boolean flag = true; // 폭발 문자열이 있는지를 체크하기 위한 변수

                // 폭발 문자열의 길이만큼 반복
                for(int j = 0; j < boom.length(); j++) {
                    // 스택의 길이 - 폭발 문자열의 길이를 빼고 거기서 부터 시작
                    // 폭발 문자열과 다르면 탈출
//                    System.out.print(st.get(st.size() - boom.length() + j) + " ");
                    if(st.get(st.size() - boom.length() + j) != boom.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
//                System.out.println();
                if (flag) {
                    for(int j = 0; j < boom.length(); j++) {
                        st.pop();
                    }
                }
            }
        }

        // 쪼개져있는 문자들을 문자열로 만들어주기
        StringBuilder sb = new StringBuilder();
        for(Character c : st) {
            sb.append(c);
        }

        // 문자열의 길이가 0이라면 FRULA 출력, 아니라면 문자열 출력
        System.out.println(sb.length() == 0? "FRULA" : sb.toString());
    }
}
