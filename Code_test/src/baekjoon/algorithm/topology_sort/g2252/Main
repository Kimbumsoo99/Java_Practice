package baekjoon.algorithm.topology_sort.g2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<Integer>[] Graph;
	static int N, M, count[];
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Graph = new LinkedList[N + 1];
		count = new int[N + 1];
		visit = new boolean[N + 1];
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N + 1; i++) {
			Graph[i] = new LinkedList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			Graph[A].add(B);
			count[B]++;
		}

		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for (int i = 1; i < N + 1; i++) {
			if (count[i] == 0) {
				deque.offer(i);
			}
		}

		topology(deque);
		System.out.println(sb);
	}

	static void topology(ArrayDeque<Integer> deque) {
		while (!deque.isEmpty()) {
			int tmp = deque.pollFirst();
			sb.append(tmp + " ");
			for (int next : Graph[tmp]) {
				count[next]--;
				if (count[next] == 0) {
					deque.offer(next);
				}
			}
		}
	}
}
