package baekjoon.dfs.g9328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static Character[][] Graph;
    static boolean[][] visit;
    static int[] dx = new int[] { 0, -1, 0, 1 };
    static int[] dy = new int[] { 1, 0, -1, 0 };
    static int N, M;
    static HashMap<Character, ArrayList<int[]>> door = new HashMap<>();
    static HashSet<Character> key = new HashSet<>();
    static int answer = 0;
    static ArrayList<int[]> startPoint = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int test_case = 1; test_case < T + 1; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
//			System.out.println(N + " " + M);

            /**
             * 초기화 부분
             */
            Graph = new Character[N][M]; // map 저장 배열
            visit = new boolean[N][M]; // map 방문 확인 배열
            door = new HashMap<>();
            key = new HashSet<>();
            startPoint = new ArrayList<>();
            answer = 0;

            for (int i = 0; i < N; i++) {
                String mapY = br.readLine(); // 한 줄 입력 받아오기
                for (int j = 0; j < M; j++) {
//                    System.out.print(mapY.charAt(j)+"");
                    Graph[i][j] = mapY.charAt(j); // 각각 저장
//                    System.out.println(i + " " + j + " " + Graph[i][j]);
                    if (!".*$".contains(String.valueOf(Graph[i][j]))) { // 알파벳 (= 문 또는 열쇠)
                        if (Graph[i][j] <= 'Z') {
                            char keyL = String.valueOf(Graph[i][j]).toLowerCase().charAt(0); // 열쇠 형태로 만들기
                            if (!door.containsKey(keyL)) { // 문 추가 하기
                                door.put(keyL, new ArrayList<>());
                            }
                            door.get(keyL).add(new int[] { i, j });
                        }
                    }
                }
            }

            /**
             * 초기 키 정보를 받는 부분
             */
            String keyString = br.readLine();
            if (!keyString.equals("0")) {
                for (int i = 0; i < keyString.length(); i++) {
                    char k = keyString.charAt(i); // 키 각각 하나 씩 찾기
                    key.add(k); // 열쇠 Set에 저장
                }
            }
            // 여기까지

            getStartPoint1(); // 시작점을 찾아오는 함수
            bfs();
            System.out.println(answer);
        }

    }

    static void bfs() {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        for (int[] is : startPoint) {
            if (Graph[is[0]][is[1]] >= 'a' && Graph[is[0]][is[1]] <= 'z') {
                if (door.containsKey(Graph[is[0]][is[1]])) {
                    for (int[] js : door.get(Graph[is[0]][is[1]])) {
                        Graph[js[0]][js[1]] = '.';
                    }
                }
            }
//            System.out.println("시작 포인트 " + is[0] + " " +is[1]);
            dq.offer(is);
            visit[is[0]][is[1]] = true;
        }

        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
//            System.out.println(Arrays.toString(tmp));
            for (int i = 0; i < 4; i++) {
                int nextY = tmp[0] + dy[i];
                int nextX = tmp[1] + dx[i];
                if (isMapIn(nextY, nextX)) {
                    if (!visit[nextY][nextX] && Graph[nextY][nextX] != '*') {
                        if (Graph[nextY][nextX] == '.') {
                            dq.offer(new int[] { nextY, nextX });
                            visit[nextY][nextX] = true;
                        } else if (Graph[nextY][nextX] == '$') { // 문서인 경우
//                            System.out.println("$");
                            answer++;
                            dq.offer(new int[] { nextY, nextX });
                            visit[nextY][nextX] = true;
                        } else if (Graph[nextY][nextX] > 'Z') { // 키 인경우
                            // 키 추가 및 도어 삭제
                            // 각 도어 삭제하면서 모든 도어에 해당되는 부분 . 으로 변경
                            // .으로 변경한게 방문했다면 dq에 넣기.

                            dq.offer(new int[] { nextY, nextX });
                            visit[nextY][nextX] = true;
                            char getKey = Graph[nextY][nextX];
                            if (door.containsKey(getKey)) {
                                for (int[] js : door.get(getKey)) {
                                    if(visit[js[0]][js[1]]){
                                        dq.offer(new int[] { js[0], js[1] });
                                    }else{
                                        Graph[js[0]][js[1]] = '.';
                                    }
                                }
                            }

                        } else { // 문 인 경우 (대문자인 경우)
                            char getDoor = lower(Graph[nextY][nextX]); // 열쇠값으로 변경
//							door.get(getDoor).add(new int[] { nextY, nextX });
                            if (key.contains(getDoor)) {
                                dq.offer(new int[]{nextY, nextX});
                            }
                            visit[nextY][nextX] = true;

                            // 문을 발견했으면, visit 처리
                        }
                    }
                }
            }
        }
    }

    static boolean isMapIn(int y, int x) {
        if (y >= 0 && x >= 0 && y < N && x < M) {
            return true;
        }
        return false;
    }

    static char lower(char up) {
        return (char) ((int) up + 32);
    }

    static void getStartPoint1(){
        // 맨 윗 줄
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < (N == 1 ? 1 : 2); j++) {
                int idx = j == 0 ? 0 : N - 1;
                if (Graph[idx][i] == '*') {
                    continue;
                } else if (Graph[idx][i] == '.') {
                    startPoint.add(new int[]{idx, i});
                } else if (Graph[idx][i] == '$') {
                    answer++;
                    Graph[idx][i] = '.';
                    startPoint.add(new int[]{idx, i});
                } else if (Graph[idx][i] <= 'Z') {
                    if (key.contains(lower(Graph[idx][i]))) {
                        startPoint.add(new int[]{idx, i});
                    } else {
                        visit[idx][i] = true;
                    }
                } else {
                    startPoint.add(new int[]{idx, i});
                    if (door.containsKey(Graph[idx][i])) {
                        for (int[] index : door.get(Graph[idx][i])) {
                            if (visit[index[0]][index[1]]) {
                                startPoint.add(new int[]{index[0], index[1]});
                            } else {
                                Graph[index[0]][index[1]] = '.';
                            }
                        }
                    }
                }
            }
        }
//        System.out.println(startPoint.size() + " 윗 줄 ");
        // 양쪽 끝 줄
        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j < 2; j++) {
                int idx = j == 0 ? 0 : M - 1;
//                System.out.println(i + " " + idx + " " +Graph[i][idx]);
                if (Graph[i][idx] == '*') {
                    continue;
                } else if (Graph[i][idx] == '.') {
                    startPoint.add(new int[]{i, idx});
                }else if(Graph[i][idx] == '$'){
                    answer++;
                    Graph[i][idx] = '.';
                    startPoint.add(new int[]{i,idx});
                } else if (Graph[i][idx] <= 'Z') {
                    if (key.contains(lower(Graph[i][idx]))) {
                        startPoint.add(new int[]{i, idx});
                    }else{
                        visit[i][idx] = true;
                    }
                }else{
                    startPoint.add(new int[]{idx, i});
                    if (door.containsKey(Graph[idx][i])) {
                        for (int[] index : door.get(Graph[i][idx])) {
                            if (visit[index[0]][index[1]]) {
                                startPoint.add(new int[]{index[0], index[1]});
                            } else {
                                Graph[index[0]][index[1]] = '.';
                            }
                        }
                    }
                }
            }
        }
//        System.out.println(startPoint.size() + " 아랫 줄 ");

    }
//    static void getStartPoint() {
//        for (int i = 0; i < N; i++) {
//            if (Graph[i][M - 1] == '.' || (Graph[i][M - 1] >= 'a' && Graph[i][M - 1] <= 'z')) {
//                startPoint.add(new int[] { i, M - 1 });
//            } else if (Graph[i][M - 1] >= 'A' && Graph[i][M - 1] <= 'Z') {
//                if (key.contains(lower(Graph[i][M - 1]))) {
//                    startPoint.add(new int[] { i, M - 1 });
//                }
//            }else if(Graph[i][M - 1] != '*'){ // 달러인 경우
//                answer++;
//                startPoint.add(new int[] { i, M - 1 });
//            }
//            if (Graph[i][0] == '.' || (Graph[i][0] >= 'a' && Graph[i][0] <= 'z')) {
//                startPoint.add(new int[] { i, 0 });
//            } else if (Graph[i][0] >= 'A' && Graph[i][0] <= 'Z') {
//                if (key.contains(lower(Graph[i][0]))) {
//                    startPoint.add(new int[] { i, 0 });
//                }
//            }else if(Graph[i][0] != '*'){
//                startPoint.add(new int[] { i, 0 });
//                answer++;
//            }
//        }
//        for (int i = 0; i < M; i++) {
//            if (Graph[N - 1][i] == '.' || (Graph[N - 1][i] >= 'a' && Graph[N - 1][i] <= 'z')) {
//                startPoint.add(new int[] { N - 1, i });
//            } else if (Graph[N - 1][i] >= 'A' && Graph[N - 1][i] <= 'Z') {
//                if (key.contains(lower(Graph[N - 1][i]))) {
//                    startPoint.add(new int[] { N - 1, i });
//                }
//            }else if(Graph[N - 1][i] != '*'){
//                answer++;
//                startPoint.add(new int[] { N - 1, i });
//            }
//            if (Graph[0][i] == '.' || (Graph[0][i] >= 'a' && Graph[0][i] <= 'z')) {
//                startPoint.add(new int[] { 0, i });
//            } else if (Graph[0][i] >= 'A' && Graph[0][i] <= 'Z') {
//                if (key.contains(lower(Graph[0][i]))) {
//                    startPoint.add(new int[] { 0, i });
//                }
//            }else if(Graph[0][i] != '*'){
//                answer++;
//                startPoint.add(new int[] { 0, i });
//            }
//        }
//    }
}