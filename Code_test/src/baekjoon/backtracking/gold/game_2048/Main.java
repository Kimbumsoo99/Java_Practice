package baekjoon.backtracking.gold.game_2048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int[][] Graph;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Graph = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(N, Graph, 0);
        System.out.println(max);
    }

    private static void recur(int N, int[][] Graph, int depth) {
        if (depth == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(max, Graph[i][j]);
                }
            }
            return;
        }

        int tmp[][];
        for (int i = 0; i < 4; i++) {
            tmp = new int[N][N];
            if (i == 0) { // 왼쪽 슬라이드
                for (int j = 0; j < N; j++) {
                    ArrayList<Integer> sumList = new ArrayList<>();
                    int current = -1;
                    for (int k = 0; k < N; k++) {
                        // 1. 블록이 선택되지 않은 상태로 숫자 블록 만난 경우
                        // 2. 블록이 선택되고, 페어 블록이 같은 숫자인 경우 (합쳐짐)
                        // 3. 블록이 선택되고, 페어 블록이 성립이 안되는 경우 다시 블록 선택 (이전 블록 넘어가기)
                        if (current == -1 && Graph[j][k] != 0) {
                            current = Graph[j][k];
                        } else if (current != -1 && Graph[j][k] != 0 && current == Graph[j][k]) {
                            sumList.add(current * 2);
                            current = -1;
                        } else if (current != -1 && Graph[j][k] != 0) {
                            sumList.add(current);
                            current = Graph[j][k];
                        }
                    }
                    if (current != -1) {
                        sumList.add(current);
                    }
                    int idx = 0;
                    for (Integer sum : sumList) {
                        tmp[j][idx++] = sum;
                    }
                }
            } else if (i == 1) { // 오른쪽 슬라이드
                for (int j = 0; j < N; j++) {
                    ArrayList<Integer> sumList = new ArrayList<>();
                    int current = -1;
                    for (int k = N - 1; k >= 0; k--) {
                        // 1. 블록이 선택되지 않은 상태로 숫자 블록 만난 경우
                        // 2. 블록이 선택되고, 페어 블록이 같은 숫자인 경우 (합쳐짐)
                        // 3. 블록이 선택되고, 페어 블록이 성립이 안되는 경우 다시 블록 선택 (이전 블록 넘어가기)
                        if (current == -1 && Graph[j][k] != 0) {
                            current = Graph[j][k];
                        } else if (current != -1 && Graph[j][k] != 0 && current == Graph[j][k]) {
                            sumList.add(current * 2);
                            current = -1;
                        } else if (current != -1 && Graph[j][k] != 0) {
                            sumList.add(current);
                            current = Graph[j][k];
                        }
                    }
                    if (current != -1) {
                        sumList.add(current);
                    }
                    int idx = N - 1;
                    for (Integer sum : sumList) {
                        tmp[j][idx--] = sum;
                    }
                }
            } else if (i == 2) { // 아래 슬라이드
                for (int j = 0; j < N; j++) {
                    ArrayList<Integer> sumList = new ArrayList<>();
                    int current = -1;
                    for (int k = N - 1; k >= 0; k--) {
                        // 1. 블록이 선택되지 않은 상태로 숫자 블록 만난 경우
                        // 2. 블록이 선택되고, 페어 블록이 같은 숫자인 경우 (합쳐짐)
                        // 3. 블록이 선택되고, 페어 블록이 성립이 안되는 경우 다시 블록 선택 (이전 블록 넘어가기)
                        if (current == -1 && Graph[k][j] != 0) {
                            current = Graph[k][j];
                        } else if (current != -1 && Graph[k][j] != 0 && current == Graph[k][j]) {
                            sumList.add(current * 2);
                            current = -1;
                        } else if (current != -1 && Graph[k][j] != 0) {
                            sumList.add(current);
                            current = Graph[k][j];
                        }
                    }
                    if (current != -1) {
                        sumList.add(current);
                    }
                    int idx = N - 1;
                    for (Integer sum : sumList) {
                        tmp[idx--][j] = sum;
                    }
                }
            } else if (i == 3) {
                for (int j = 0; j < N; j++) {
                    ArrayList<Integer> sumList = new ArrayList<>();
                    int current = -1;
                    for (int k = 0; k < N; k++) {
                        // 1. 블록이 선택되지 않은 상태로 숫자 블록 만난 경우
                        // 2. 블록이 선택되고, 페어 블록이 같은 숫자인 경우 (합쳐짐)
                        // 3. 블록이 선택되고, 페어 블록이 성립이 안되는 경우 다시 블록 선택 (이전 블록 넘어가기)
                        if (current == -1 && Graph[k][j] != 0) {
                            current = Graph[k][j];
                        } else if (current != -1 && Graph[k][j] != 0 && current == Graph[k][j]) {
                            sumList.add(current * 2);
                            current = -1;
                        } else if (current != -1 && Graph[k][j] != 0) {
                            sumList.add(current);
                            current = Graph[k][j];
                        }
                    }
                    if (current != -1) {
                        sumList.add(current);
                    }
                    int idx = 0;
                    for (Integer sum : sumList) {
                        tmp[idx++][j] = sum;
                    }
                }
            }
            recur(N, tmp, depth + 1);
        }

    }

    static void draw(int[][] Graph) {
        for (int i = 0; i < Graph.length; i++) {
            for (int j = 0; j < Graph.length; j++) {
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
