package swea.tbd.n2117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 방법 1,2 생각 났음
// 1. (무난) 집 Point를 시작점으로 모두 BFS 완탐으로 가장 큰 값 찾기
// 2. (확실?) 모든 집간의 거리를 구해서 집간의 거리가 가장 짧은 집이 제일 많은 집 찾은 뒤,
//           해당 집에서 BFS로 최대 집 거리 구하기
class House{
    int y, x, distance;

    House(int y, int x, int distance) {
        this.y = y;
        this.x = x;
        this.distance = distance;
    }
}

public class Solution {
    static int N, M, Graph[][], answer;
    static ArrayList<House> houseList;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int test_case = 1; test_case < T+1; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            answer = 0;
            Graph = new int[N][N];
            houseList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    Graph[i][j] = Integer.parseInt(st.nextToken());
                    if (Graph[i][j] == 1) {
                        houseList.add(new House(i, j, 0));
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    PriorityQueue<House> pq = new PriorityQueue<>((o1, o2) -> {
                        return Integer.compare(o1.distance, o2.distance);
                    });
                    for (House house : houseList) {
                        house.distance = getLen(i, house.y, j, house.x);
                        pq.offer(house);
                    }
                    int len = 0;
                    int limitCost = 0;
                    int home = 0; // 찾은 home 개수
                    int costSum = 0; // home 만큼 추가
                    while (!pq.isEmpty()) {
                        House tmp = pq.poll();
                        len = getLen(i, tmp.y, j, tmp.x) + 1;
                        limitCost = getCost(len);
                        home++;
                        costSum = home * M;
                        if (costSum - limitCost >= 0 && answer < home) {
//                            System.out.println(
//                                i + ", " + j + " : " + limitCost + " " + costSum + " " + home);
                            answer = home;
                        }
                    }
                }
            }
            sb.append("#" + test_case + " " + answer + "\n");
        }
        System.out.println(sb);
    }

    static int getLen(int cY, int nY, int cX, int nX) {
        return Math.abs(cY - nY) + Math.abs(cX - nX);
    }

    static int getCost(int k) {
        return k * k + (k - 1) * (k - 1);
    }

}
