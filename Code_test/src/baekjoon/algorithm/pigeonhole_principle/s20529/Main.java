package baekjoon.algorithm.pigeonhole_principle.s20529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 가장 가까운 세 사람의 심리적 거리, 실버 1
public class Main {
    static ArrayList<String> friends;
    static int min = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            friends = new ArrayList<String>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                String mbti = st.nextToken();
                friends.add(mbti);
            }
//			for (int i = 2; i < N; i++) {
//				getClose(friends.get(i - 2), friends.get(i - 1), friends.get(i));
//			}

            if (N > 32) {
                System.out.println(0);
            } else {
                min = Integer.MAX_VALUE;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (i == j)
                            continue;
                        for (int k = 0; k < N; k++) {
                            if (i == k || j == k)
                                continue;
                            getClose(friends.get(i), friends.get(j), friends.get(k));
                        }
                    }
                }
                System.out.println(min);
            }
        }
    }

    static void getClose(String str1, String str2, String str3) {
        int tmp = 0;
        for (int i = 0; i < 4; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                tmp++;
            }
            if (str2.charAt(i) != str3.charAt(i)) {
                tmp++;
            }
            if (str3.charAt(i) != str1.charAt(i)) {
                tmp++;
            }
        }
        min = Math.min(min, tmp);
    }
}

