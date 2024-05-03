package swea.proB.day2.a_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 트리 실습
 * 1231. [S/W 문제해결 기본] 9일차 - 중위순회
 *
 * 후기 : 좀 어렵게 푼 듯? 전에 했던 기억이 남아있어서 그래도 풀었다.
 */


class Node {
	int idx;
	char val;
	Integer[] child = new Integer[2];

	@Override
	public String toString() {
		return "Node [idx=" + idx + ", val=" + val + "]";
	}

	public Node(int idx, char val) {
		super();
		this.idx = idx;
		this.val = val;
	}

	public Node() {
		// TODO Auto-generated constructor stub
	}
}

class Tree {

}

public class Solution {
	static Node[] nodes;
	static int N;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			init();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				char val = st.nextToken().charAt(0);
				Node node = new Node(idx, val);
				nodes[idx] = node;
				int token = 0;
				while (st.hasMoreTokens()) {
					int c = Integer.parseInt(st.nextToken());
					node.child[token++] = c;
				}
			}
			inOrder(1);
			System.out.println("#" + test_case + " " + sb);
		}

	}

	static void inOrder(int cur) {
		if (nodes[cur].child[0] == null) {
			sb.append(nodes[cur].val);
			return;
		}
		inOrder(nodes[cur].child[0]);
		sb.append(nodes[cur].val);
		if (nodes[cur].child[1] == null) {
			return;
		}
		inOrder(nodes[cur].child[1]);
	}

	static void init() {
		nodes = new Node[N + 1];
		sb = new StringBuilder();
	}
}
