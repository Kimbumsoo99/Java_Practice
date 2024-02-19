package swea.d3.n6808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
    static int[] arr = new int[9], answer, in = new int[9];
    static int diff[] = new int[9]; // 인영이 카드
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int test_case = 1; test_case < T + 1; test_case++) {
            st = new StringTokenizer(br.readLine());
            answer = new int[2];
            int tmp = 0;
            for (int i = 0; i < 9; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                tmp = tmp | (1 << arr[i]);
            }
            int idx = 0;
            for (int i = 1; i < 19; i++) {
                if ((tmp & (1 << i)) == 0) {
                    in[idx++] = i;
                }
            }
//			System.out.println(Arrays.toString(arr) + " " + Arrays.toString(in));
            visit = new boolean[9];
            dfs(0, 0, 0);
            System.out.println("#" + test_case + " " + answer[0] + " " + answer[1]);
        }
    }

    /**
     *
     * @param depth
     * @param score 규영이 점수
     * @param other 인영이 점수
     */
    static void dfs(int depth, int score, int other) {
        if (depth == 9) {
//			System.out.println(Arrays.toString(arr));
//			System.out.println(Arrays.toString(diff));
            if (score > other) {
                answer[0]++; // 규영이가 이기는 경우
            } else {
                answer[1]++; // 규영이가 지는 경우
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!visit[i]) {
                int tmpScore = score;
                int tmpOther = other;
                visit[i] = true;
                diff[depth] = in[i]; // 인영이 카드 diff
                if (arr[depth] > diff[depth]) {
                    tmpScore += arr[depth] + diff[depth];
                } else {
                    tmpOther += arr[depth] + diff[depth];
                }
                dfs(depth + 1, tmpScore, tmpOther);
                visit[i] = false;
            }
        }
    }
}

