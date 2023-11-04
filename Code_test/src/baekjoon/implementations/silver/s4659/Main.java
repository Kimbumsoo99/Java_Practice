package baekjoon.implementations.silver.s4659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static HashSet<Character> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        set.add('a');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('e');
        while (true) {
            String tmp = br.readLine();
            if (tmp.equals("end")) {
                break;
            }
            boolean flag = true;
            if (!validation1(tmp)) {
//                System.out.println(1);
                flag = false;
            } else if (!validation2(tmp)) {
//                System.out.println(2);
                flag = false;
            } else if (!validation3(tmp)) {
//                System.out.println(3);
                flag = false;
            }

            if (flag) {
                System.out.println("<" + tmp + "> is acceptable.");
            } else {
                System.out.println("<" + tmp + "> is not acceptable.");
            }
        }
    }

    private static boolean validation3(String tmp) {
        // 같은 글자가 연속적으로 두번 오면 안된다. 그러나 oo와 ee는 허용한다.
        for (int i = 0; i < tmp.length() - 1; i++) {
            String sub = tmp.substring(i, i + 2);
            if (sub.charAt(0) == sub.charAt(1) && sub.charAt(0) != 'e' && sub.charAt(0) != 'o') {
                return false;
            }
        }
        return true;
    }

    private static boolean validation2(String tmp) {
        // 모음이 3개 또는 자음이 3개 연속이면 실패
        boolean flag = false; // 모음이면 트루
        if (set.contains(tmp.charAt(0))) {
            flag = true;
        }

        int count = 1;
        for (int i = 1; i < tmp.length(); i++) {
            if ((flag && set.contains(tmp.charAt(i))) || (!flag && !set.contains(tmp.charAt(i)))) {
                count++;
            } else {
                flag = !flag;
                count = 1;
            }

            if (count == 3) {
                return false;
            }
        }
        return true;
    }


    private static boolean validation1(String tmp) {
        // 모음 하나라도 포함 돼 있으면 트루
        for (int i = 0; i < tmp.length(); i++) {
            if (set.contains(tmp.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
