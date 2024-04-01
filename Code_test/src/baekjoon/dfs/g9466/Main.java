package baekjoon.dfs.g9466;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, next[], answer;
    static boolean[] visit, finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int test_case = 1; test_case < T + 1; test_case++) {
            N = Integer.parseInt(br.readLine());
            next = new int[N + 1];
            answer = N;
            visit = new boolean[N + 1];
            finished = new boolean[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                next[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < N + 1; i++) {
                if (!visit[i] && !finished[i]) {
                    dfs(i, 0);
//					System.out.println(Arrays.toString(finished));
//					System.out.println(answer);
                }
            }
            System.out.println(answer);
        }
    }

    static void dfs(int cur, int count) {
        if (visit[cur]) {
            finished[cur] = true;
            answer--;
            for (int i = next[cur]; i != cur; i = next[i]) {
                finished[cur] = true;
                answer--;
            }
            return;
        }
        visit[cur] = true;
        if (!finished[next[cur]]) {
            dfs(next[cur], count + 1);
        }
        finished[cur] = true;
    }
}
