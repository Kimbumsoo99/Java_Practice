package baekjoon.implementations.gold.card_shuffle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] card;
    static int[] init;
    static int[] mix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        card = new int[N];
        mix = new int[N];
        init = new int[N];
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
            init[i] = card[i];
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            mix[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        boolean flag = true;
        while (true) {
            if (count>0 && validation2()) {
                flag = false;
                break;
            } else if (validation()) {
                break;
            }
            shuffle();
            count++;

        }
        if (flag) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }

    }

    private static boolean validation2() {
        for (int i = 0; i < card.length; i++) {
            if (init[i] != card[i]) {
                return false;
            }
        }
        return true;
    }

    private static void shuffle() {
        int[] tmp = new int[card.length];
        for (int i = 0; i < card.length; i++) {
            tmp[mix[i]] = card[i];
        }
        card = tmp;
    }

    private static boolean validation() {
        for (int i = 0; i < card.length; i++) {
            if (card[i] != i % 3) {
                return false;
            }
        }
        return true;
    }

}
