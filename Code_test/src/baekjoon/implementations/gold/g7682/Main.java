package baekjoon.implementations.gold.g7682;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder answerBuilder = new StringBuilder();
    static int[][] search = new int[][]{
        {0, 1}, {0, 0}, {0, 2},
        {1, 0}, {0, 0}, {2, 0},
        {1, 2}, {0, 2}, {2, 2},
        {2, 1}, {2, 0}, {2, 2},
        {1, 1}, {0, 0}, {2, 2},
        {1, 1}, {0, 1}, {2, 1},
        {1, 1}, {0, 2}, {2, 0},
        {1, 1}, {1, 0}, {1, 2}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String p = br.readLine();
            if (p.equals("end")) {
                break;
            }

            char[] arr = p.toCharArray();
            if (solution(arr)) {
                answerBuilder.append("valid\n");
            } else {
                answerBuilder.append("invalid\n");
            }
        }
        System.out.println(answerBuilder.toString());
    }

    private static boolean solution(char[] arr) {
        int[][] Graph = new int[3][3];
        int[] count = new int[3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Graph[i][j] = convert(arr[i * 3 + j]);
                count[Graph[i][j]]++;
            }
        }

        return isAnswer1(Graph, count) || isAnswer2(Graph, count) || isAnswer3(Graph, count);
    }


    // .이 짝수 X가 3개 이상 연결
    private static boolean isAnswer3(int[][] Graph, int[] count) {
        if (count[0] % 2 == 1 || count[0] > 4 || count[1] != count[2] + 1) {
            return false;
        }
        // 탐색
        return isThree(Graph, 1) && !isThree(Graph, 2);
    }

    private static boolean isThree(int[][] Graph, int v) {
        for (int i = 0; i < 8; i++) {
            int a = Graph[search[i * 3][0]][search[i * 3][1]];
            int b = Graph[search[i * 3 + 1][0]][search[i * 3 + 1][1]];
            int c = Graph[search[i * 3 + 2][0]][search[i * 3 + 2][1]];
            if(a == v && a == b && a == c){
                return true;
            }
        }
        return false;
    }

    // .이 홀수 O가 3개 이상 연결
    private static boolean isAnswer2(int[][] Graph, int[] count) {
        // 실패 조건
        if (count[0] % 2 == 0 || count[0] > 3 || count[1] != count[2]) {
            return false;
        }
        // 탐색
        return isThree(Graph, 2) && !isThree(Graph, 1);
    }

    // .이 0개 X 5개 O 4개 -> 게임끝
    static boolean isAnswer1(int[][] Graph, int[] count) {
        if (count[0] == 0 && count[1] == 5 && count[2] == 4) {
            return !isThree(Graph, 2);
        }
        return false;
    }

    static int convert(char c){
        switch (c){
            case '.':
                return 0;
            case 'O':
                return 2;
            default:
                return 1;
        }
    }
}
