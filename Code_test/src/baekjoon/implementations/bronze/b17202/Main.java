package baekjoon.implementations.bronze.b17202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] phone1 = br.readLine().toCharArray();
        char[] phone2 = br.readLine().toCharArray();

        char[] phone = new char[16];
        for (int i = 0; i < 8; i++) {
            phone[i * 2] = phone1[i];       // 0 2 4 6 8 10 12 14
            phone[i * 2 + 1] = phone2[i];   // 1 3 5 7 9 11 13 15
        }

        int length = phone.length;

        while (length > 2) {
            for (int i = 0; i < length - 1; i++) {
                int tmp = (phone[i] - '0') + (phone[i + 1] - '0');
                phone[i] = (char) ((tmp % 10) + '0');
            }

            length--;
        }
        System.out.println(phone[0] + "" + phone[1]);
    }

}
