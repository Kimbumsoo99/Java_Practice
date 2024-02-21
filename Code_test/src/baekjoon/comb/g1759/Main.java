package baekjoon.comb.g1759;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit;
    static int[] arr;
    static ArrayList<Integer> moList = new ArrayList<>();
    static ArrayList<Integer> jaList = new ArrayList<>();
    static int[] answer;
    static int min = 0, N, M, moCnt = 0, jaCnt = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visit = new boolean[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = st.nextToken().charAt(0) - 'a';
        }
        Arrays.sort(arr);
        comb(0, 0);
        System.out.println(sb);
    }

    static void comb(int depth, int idx) {
        if (depth == N) {
            if (moCnt < 1 || jaCnt < 2)
                return;
            for (int i = 0; i < M; i++) {
                if (visit[i])
                    sb.append((char) (arr[i] + 'a'));
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < M; i++) {
            if (!visit[i]) {
                visit[i] = true;
                if (isMo(arr[i]))
                    moCnt++;
                else
                    jaCnt++;
                comb(depth + 1, i + 1);
                visit[i] = false;
                if (isMo(arr[i]))
                    moCnt--;
                else
                    jaCnt--;
            }
        }
    }

    static boolean isMo(int c) {
        return (c == 0 || c == 'e' - 'a' || c == 'i' - 'a' || c == 'o' - 'a' || c == 'u' - 'a');
    }
}
