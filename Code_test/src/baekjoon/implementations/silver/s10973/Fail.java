package baekjoon.implementations.silver.s10973;

// 조건이 N <= 10000이므로, dfs로 풀이가 안된다.
import java.util.*;
import java.io.*;
public class Fail {
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] visit;
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String arr = "";
        visit = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr += st.nextToken();
        }

        // 모든 수열을 다 생성한다.
        dfs(arr, 0, "");

        // 우선순위에 맞게 정렬한다.
        Collections.sort(list);
        // draw();
        int answer = -1;
        for (int i = 0; i < list.size(); i++) {
            if (arr.equals(list.get(i))) {
                answer = i - 1;
                break;
            }
        }
        if (answer == -1) {
            System.out.println(answer);
        } else {
            try {
                String result = list.get(answer);
                StringBuilder sb = new StringBuilder();
                for (char c : result.toCharArray()) {
                    sb.append(c).append(" ");
                }
                System.out.println(sb);
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }


    static void draw() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static void dfs(String arr, int depth, String tmp) {
        if (depth == arr.length()) {
            System.out.println(tmp);
            if (arr.equals(tmp)) {
                check = true;
            }
            list.add(tmp);
            return;
        }

        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(arr, depth + 1, tmp + (i + 1));
                if (check) {
                    return;
                }
                visit[i] = false;
            }
        }
    }
}
