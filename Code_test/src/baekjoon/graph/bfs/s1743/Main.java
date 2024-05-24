package baekjoon.graph.bfs.s1743;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, Graph[][], answer;
	static boolean[][] visit;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Graph = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			Graph[y][x] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && Graph[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		System.out.println(answer);
	}

	static void bfs(int y, int x) {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] { y, x });
		int count = 1;
		visit[y][x] = true;
		while (!dq.isEmpty()) {
			int[] tmp = dq.pollFirst();
			for (int i = 0; i < 4; i++) {
				int nY = tmp[0] + dy[i];
				int nX = tmp[1] + dx[i];
				if (isMap(nY, nX) && Graph[nY][nX] == 1 && !visit[nY][nX]) {
					dq.offer(new int[] { nY, nX });
					visit[nY][nX] = true;
					count++;
				}
			}
		}
		answer = Math.max(answer, count);
	}

	static boolean isMap(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}
}
