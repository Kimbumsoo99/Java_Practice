package baekjoon.implementations.silver.s10431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 줄세우기, 실버 V, 10431
public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<int[]> answerList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int caseNum = Integer.parseInt(st.nextToken());
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < 20; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                list.add(tmp);
            }
            int count = lineGet(list);
            answerList.add(new int[]{caseNum, count});
            list.clear();
        }

        for (int[] out : answerList) {
            sb.append(out[0]).append(" ").append(out[1]).append("\n");
        }
        System.out.println(sb);
    }

    private static int lineGet(ArrayList<Integer> list) {
        int count = 0;
        ArrayList<Integer> line = new ArrayList<>();
        for (int child : list) {
            // 자기보다 앞에 큰 사람을 찾는 것
            int tallFlag = -1;
            for (int i = 0; i < line.size(); i++) {
                if (line.get(i) > child) {
                    tallFlag = i;
                    break;
                }
            }
            if (tallFlag != -1) {
                line.add(tallFlag, child);
                count += line.size() - tallFlag - 1;
            } else {
                line.add(child);
            }
        }
        return count;
    }

}
