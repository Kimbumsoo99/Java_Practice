package baekjoon.comb.g17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N, peoples[];
    static int[][] Graph;
    //	static ArrayList<Integer>[] lists;
    static boolean[] visit;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        peoples = new int[N + 1];
//		lists = new ArrayList[N + 1];
        Graph = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            peoples[i] = Integer.parseInt(st.nextToken());
//			lists[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            for (int j = 0; j < M; j++) {
                int B = Integer.parseInt(st.nextToken());
//				System.out.println(i + " " + B);
                Graph[i][B] = 1;
//				lists[i].add(Integer.parseInt(st.nextToken()));
            }
        }

//		for (int i = 1; i < N + 1; i++) {
//			for (int j = 1; j < N + 1; j++) {
//				System.out.print(Graph[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

        for (int i = 1; i <= N / 2; i++) {
            comb(0, 0, i);
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void comb(int depth, int idx, int end) {
        if (depth == end) {
            int A = bfs(visit, 0, end); // 연결 부분 집합, mode (0 - true가 한 집단, 1 - false가 한 집단), end는 집단의 수
            int B = bfs(visit, 1, N - end); //
            if (A == -1 || B == -1) {
                return;
            } else {
//				if (answer > Math.abs(Math.abs(A) - Math.abs(B)))
////					System.out.println(A + " " + B);
                answer = Math.min(answer, Math.abs(A - B));
            }
            return;
        }

        for (int i = idx; i < N + 1; i++) {
            if (!visit[i]) {
                visit[i] = true;
                comb(depth + 1, i + 1, end);
                visit[i] = false;
            }
        }
    }

    static int bfs(boolean[] visit, int mode, int end) {
        boolean[] link = new boolean[N + 1];
        boolean[] tmpVisit = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            link[i] = mode == 0 ? visit[i] : !visit[i];
        }
//		System.out.println(Arrays.toString(link));

        int count = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            if (link[i]) {
                deque.offer(i);
                tmpVisit[i] = true;
                count = 1;
                break;
            }
        }

        while (!deque.isEmpty()) {
            int tmp = deque.pollFirst();
            for (int i = 1; i < N + 1; i++) {
                if (link[i] && !tmpVisit[i] && Graph[tmp][i] == 1) {
                    deque.offer(i);
                    tmpVisit[i] = true;
                    count++;
                    if (count == end) {
                        int sum = 0;
                        for (int j = 1; j < N + 1; j++) {
                            if (link[j]) {
                                sum += peoples[j];
                            }
                        }
                        return sum;
                    }
                }
            }
        }
        if (count == end) {
            int sum = 0;
            for (int j = 1; j < N + 1; j++) {
                if (link[j]) {
                    sum += peoples[j];
                }
            }
            return sum;
        }
        return -1;
    }
}
