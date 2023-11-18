package baekjoon.greedy.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 모르겠다.
// 양쪽 음수 양수가 둘 다 있을 때 어떻게 풀어야하지?
public class DontKnow {

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        int min = list.get(0);
        int max = list.get(N - 1);
        int move = 0;
        if (min < 0 && max > 0) {

        } else if (max < 0) {
            int idx = list.size() - 1;
            while (idx >= 0) {
                int tmp = 0;
                boolean flag = false;
                for (int i = 0; i < M; i++) {
                    if (idx == -1) {
                        tmp = list.get(idx--);
                        flag = true;
                        break;
                    }
                    tmp = list.get(idx--);
                }
                if (!flag) {
                    tmp *= 2;
                }
                move += tmp;
            }
        } else if (min > 0) {
            int idx = 0;
            while (idx < list.size()) {
                int tmp = 0;
                boolean flag = false;
                for (int i = 0; i < M; i++) {
                    if (idx == list.size() - 1) {
                        tmp = list.get(idx++);
                        flag = true;
                        break;
                    }
                    tmp = list.get(idx++);
                }
                if (!flag) {
                    tmp *= 2;
                }
                move += tmp;
            }
        }

        System.out.println(move);
    }

}
