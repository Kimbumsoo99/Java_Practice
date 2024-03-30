package baekjoon.algorithm.mst.prim.g17472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Land {
    ArrayList<int[]> area = new ArrayList<>();
    int idx;

    Land(int idx) {
        this.idx = idx;
    }

    @Override
    public String toString() {
        return "Land [area=" + area + ", idx=" + idx + "]";
    }

}

class Node {
    int idx, next, weight;

    public Node(int idx, int next, int weight) {
        super();
        this.idx = idx;
        this.next = next;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node [idx=" + idx + ", next=" + next + ", weight=" + weight + "]";
    }

}

public class Main {
    static int N, M, Graph[][], islandCnt = 11;
    static Land[] lands = new Land[7];
    static boolean[][] island;
    static int[][] islandConnect = null;
    //	static ArrayList<Node>[] islandConnectList = null;
    static int[] dx = { 1, 0, 0, -1 }, dy = { 0, 1, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        island = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 7; i++) {
            lands[i] = new Land(i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!island[i][j] && Graph[i][j] == 1) {
                    findIslandBfs(new int[] { i, j }, islandCnt, lands[islandCnt - 10]);
                    islandCnt++;
                }
            }
        }
//		islandConnectList = new ArrayList[islandCnt - 10];
        islandConnect = new int[islandCnt - 10][islandCnt - 10];
        for (int i = 0; i < islandCnt - 10; i++) {
            Arrays.fill(islandConnect[i], Integer.MAX_VALUE);
//			islandConnectList[i] = new ArrayList<Node>();
        }

        for (int i = 1; i < (islandCnt - 10); i++) {
            for (int[] S : lands[i].area) {
                for (int j = 0; j < 4; j++) {
                    findBridge(S, Graph[S[0]][S[1]], j);
                }
            }
        }

//		for (int i = 0; i < islandCnt - 10; i++) {
//			for (int j = 0; j < islandCnt - 10; j++) {
//				System.out.print(islandConnect[i][j] + " ");
//			}
//			System.out.println();
//		}

//		draw();

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.weight - o2.weight;
        });

        int minIdx = 0;
        int minVal = Integer.MAX_VALUE;
        for (int i = 1; i < (islandCnt - 10); i++) {
            for (int j = 1; j < (islandCnt - 10); j++) {
                if (islandConnect[i][j] < minVal) {
                    minIdx = i;
                    minVal = islandConnect[i][j];
                }
            }
        }

        boolean[] visit = new boolean[islandCnt - 10];
        for (int i = 1; i < islandCnt - 10; i++) {
            if (islandConnect[minIdx][i] != Integer.MAX_VALUE)
                pq.offer(new Node(minIdx, i, islandConnect[minIdx][i]));
        }
        visit[minIdx] = true;
        int W = 0;
        int count = 1;

        while (!pq.isEmpty()) {
//			System.out.println(pq);
            Node tmp = pq.poll();
            if (visit[tmp.next]) {
                continue;
            }
            visit[tmp.next] = true;
            W += tmp.weight;
            if (++count == (islandCnt - 10) - 1)
                break;
            for (int i = 1; i < islandCnt - 10; i++) {
                if (!visit[i] && islandConnect[tmp.next][i] != Integer.MAX_VALUE) {
//					System.out.println(islandConnect[tmp.next][i]);
                    pq.offer(new Node(tmp.next, i, islandConnect[tmp.next][i]));
                }
            }

        }
//		System.out.println(count + " " + ((islandCnt - 10) - 1));
        if (count == (islandCnt - 10) - 1)
            System.out.println(W);
        else
            System.out.println(-1);
    }

    static void findBridge(int[] start, int val, int dir) {
        int curIdx = val - 10;
//		System.out.println(Arrays.toString(start) + " " + curIdx + " " + dir);
        int nextY = start[0] + dy[dir];
        int nextX = start[1] + dx[dir];
        int length = 0;
        while (isMap(nextY, nextX)) {
            if (Graph[nextY][nextX] == val) {
                return;
            } else if (Graph[nextY][nextX] == 0) {
                length++;
                nextY += dy[dir];
                nextX += dx[dir];
            } else if (length == 1) {
                return;
            } else {
                // 다른 섬에 도착한 경우
                islandConnect[curIdx][Graph[nextY][nextX] - 10] = Math
                    .min(islandConnect[curIdx][Graph[nextY][nextX] - 10], length);
//				System.out.println("찾음 " + length + " " + curIdx + " -> " + (Graph[nextY][nextX] - 10));
//				islandConnectList[curIdx].add(new Node(curIdx, Graph[nextY][nextX] - 10, length));
                return;
            }
        }
    }

    static void draw() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(lands));
    }

    static void findIslandBfs(int[] start, int val, Land land) {
        Graph[start[0]][start[1]] = val;
        island[start[0]][start[1]] = true;
        land.area.add(start);
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(start);
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (isMap(nextY, nextX) && Graph[nextY][nextX] == 1) {
                    island[nextY][nextX] = true;
                    land.area.add(new int[] { nextY, nextX });
                    Graph[nextY][nextX] = val;
                    dq.offer(new int[] { nextY, nextX });
                }
            }
        }
    }

    static boolean isMap(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }
}
