package baekjoon.solving.gold.classroom_allocation;

import java.util.*;

public class Fail {
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            list.add(new int[]{A, B});
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int idx = 1;
        int count = 1;
        int finish = list.get(0)[1];
        boolean[] visit = new boolean[N];
        visit[0] = true;
        while (true) {
//			System.out.println();
            boolean flag = false;
            for (int i = idx; i < N; i++) {
                if (visit[i]) {
                    continue;
                }

                if (finish <= list.get(i)[0]) {
                    finish = list.get(i)[1];
                    idx = i + 1;
                    visit[i] = true;
                    flag = true;
                }
            }
            if (flag) {
                continue;
            } else {
                boolean exitFlag = true;
                for (int i = 0; i < N; i++) {
                    if (!visit[i]) {
                        count++;
                        finish = list.get(i)[1];
                        idx = i + 1;
                        visit[i] = true;
                        exitFlag = false;
                        break;
                    }
                }
                if (exitFlag) {
                    break;
                }
            }
        }
        System.out.println(count);

    }
}