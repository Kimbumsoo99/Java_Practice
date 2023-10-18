package baekjoon.implementations.gold.string_boom;

import java.io.*;
import java.util.*;

public class MemoryOverReplace {
    static String str;
    static String boom;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        boom = br.readLine();

        while (true) {
            if (str.length() == 0) {
                System.out.println("FRULA");
                System.exit(0);
            }

            if (!str.contains(boom)) {
                break;
            }
            else
                str = str.replace(boom, "");
        }

        System.out.println(str);
    }
}