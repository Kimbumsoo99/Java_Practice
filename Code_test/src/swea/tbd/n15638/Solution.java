package swea.tbd.n15638;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    private static Scanner sc;
    private static UserSolution usersolution = new UserSolution();

    static final int MAX_N = 25;
    static final int MAX_L = 10;

    static final int CMD_INIT = 100;
    static final int CMD_DESTROY = 200;
    static final int CMD_ALLY = 300;
    static final int CMD_ATTACK = 400;
    static final int CMD_RECRUIT = 500;

    static int [][] Sol= new int [MAX_N][MAX_N];
    static char [][][] Monarch = new char [MAX_N][MAX_N][MAX_L+1];

    private static void String2Char(char[] buf, String str) {
        Arrays.fill(buf, (char)0);
        for (int i = 0; i < str.length(); ++i)
            buf[i] = str.charAt(i);
        buf[str.length()] = '\0';
    }

    private static int run() throws IOException {
        int isOK = 0;

        int mN;
        char[] mMonarchA= new char [MAX_L + 1];
        char[] mMonarchB = new char [MAX_L + 1];
        char[] mGeneral= new char [MAX_L + 1];
        int mOption;
        int num;

        int N = sc.nextInt();
        int cmd, result, check;

        for (int c = 0; c < N; ++c) {

            cmd =  sc.nextInt();
            switch (cmd) {
                case CMD_INIT:
                    mN = sc.nextInt();
                    for (int j = 0; j < mN; j++)
                        for (int i = 0; i < mN; i++)
                            Sol[j][i] =  sc.nextInt();

                    for (int j = 0; j < mN; j++)
                        for (int i = 0; i < mN; i++)
                            String2Char(Monarch[j][i],  sc.next());

                    usersolution.init(mN, Sol, Monarch);
                    isOK = 1;
                    break;

                case CMD_ALLY:
                    String2Char(mMonarchA,  sc.next());
                    String2Char(mMonarchB,  sc.next());
                    result = usersolution.ally(mMonarchA, mMonarchB);
                    System.out.println("result = " + result + " #" + (c + 1));
                    check = sc.nextInt();
                    if (result != check) {
                        System.out.println("!!!");
                        isOK = 0;
                    }
                    break;

                case CMD_ATTACK:
                    String2Char(mMonarchA,  sc.next());
                    String2Char(mMonarchB,  sc.next());
                    String2Char(mGeneral,  sc.next());
                    result = usersolution.attack(mMonarchA, mMonarchB, mGeneral);
                    System.out.println("result = " + result + " #" + (c + 1));
                    check = sc.nextInt();
                    if (result != check) {
                        System.out.println("!!!");
                        isOK = 0;
                    }
                    break;

                case CMD_RECRUIT:
                    String2Char(mMonarchA,  sc.next());
                    num = sc.nextInt();
                    mOption = sc.nextInt();
                    result = usersolution.recruit(mMonarchA, num, mOption);
                    System.out.println("result = " + result + " #" + (c + 1));
                    check = sc.nextInt();
                    if (result != check) {
                        System.out.println("!!!");
                        isOK = 0;
                    }
                    break;
            }
        }
        usersolution.destroy();
        return isOK;
    }

    public static void main(String[] args) throws Exception {
        int T, MARK;
        //System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
        sc = new Scanner(System.in);

        T = sc.nextInt();
        MARK = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            if (run() == 1)
                System.out.println("#" + tc + " " + MARK);
            else
                System.out.println("#" + tc + " 0");
        }
        sc.close();
    }
}

class NationInfo {
    int x, y, soldierNum;
}

class UserSolution {

    int[] parents;
    ArrayList<Integer>[] unionList;
    ArrayList<Integer>[] enemyList;

    int[][] nationPosition;
    NationInfo[] nationInfoList;

    HashMap<String, Integer> monarchHM;
    int nationCnt;

    int N;

    // 상 우상 우 우하 하 좌하 좌 좌상
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    void init(int n, int[][] mSoldier, char[][][] mMonarch) {
        N = n;

        parents = new int[8625];
        unionList = new ArrayList[625];
        enemyList = new ArrayList[625];
        for (int i = 0; i < 625; i++) {
            unionList[i] = new ArrayList<>();
            enemyList[i] = new ArrayList<>();
        }

        nationPosition = new int[25][25];
        nationInfoList = new NationInfo[8625];
        for (int i = 0; i < 8625; i++) {
            nationInfoList[i] = new NationInfo();
        }

        monarchHM = new HashMap<>();
        nationCnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String monarchName = charConvertToString(mMonarch[i][j]);

                // String -> int idx 로 변환 : HM 사용
                monarchHM.put(monarchName, monarchHM.getOrDefault(monarchName, 0) + nationCnt);

                // 최초 부모는 자기 자신
                parents[nationCnt] = nationCnt;

                // 위치 기록
                nationPosition[i][j] = nationCnt;

                // 국가 정보 기록
                nationInfoList[nationCnt].soldierNum = mSoldier[i][j];
                nationInfoList[nationCnt].x = i;
                nationInfoList[nationCnt].y = j;

                // 자기 자신도 자신의 동맹에 추가
                unionList[nationCnt].add(nationCnt);

                nationCnt++;
            }
        }

        nationCnt = N * N;
    }

    void destroy() {
    }

    int ally(char[] mMonarchA, char[] mMonarchB) {
        String monarchA = charConvertToString(mMonarchA);
        String monarchB = charConvertToString(mMonarchB);

        int idxA = monarchHM.get(monarchA);
        int idxB = monarchHM.get(monarchB);

        if (isUnion(idxA, idxB)) {
            return -1;
        }
        if (isEnemy(idxA, idxB)) {
            return -2;
        }

        makeUnion(idxA, idxB);

        return 1;
    }

    int attack(char[] mMonarchA, char[] mMonarchB, char[] mGeneral) {
        String monarchA = charConvertToString(mMonarchA);
        String monarchB = charConvertToString(mMonarchB);
        String general = charConvertToString(mGeneral);

        int idxA = monarchHM.get(monarchA);
        int idxB = monarchHM.get(monarchB);

        // 동맹 관계면 -1 반환
        if (isUnion(idxA, idxB)) {
            return -1;
        }

        // 인접 동맹 확인
        int Bx = nationInfoList[idxB].x;
        int By = nationInfoList[idxB].y;

        boolean isEnemy = false;
        for (int d = 0; d < 8; d++) {
            int nx = Bx + dx[d];
            int ny = By + dy[d];

            if (isBoundary(nx, ny)) {
                // 적군의 루트와 다음 좌표에 위치한 군주의 루트가 같으면 적군이 존재하는 것
                if (findSet(idxA) == findSet(nationPosition[nx][ny])) {
                    isEnemy = true;
                    break;
                }
            }
        }

        // 하나라도 적군이 없다면 -2 반환
        if (!isEnemy) {
            return -2;
        }

        makeEnemy(idxA, idxB);

        int totalSoldierA = 0;
        int totalSoldierB = nationInfoList[idxB].soldierNum;
        int dispatchCnt = 0;

        for (int d = 0; d < 8; d++) {
            int nx = Bx + dx[d];
            int ny = By + dy[d];

            if (isBoundary(nx, ny)) {
                // B 기준 - A는 적군. 적군이면 병사 수 / 2 파견
                if (findSet(idxA) == findSet(nationPosition[nx][ny])) {
                    dispatchCnt = nationInfoList[nationPosition[nx][ny]].soldierNum / 2;
                    nationInfoList[nationPosition[nx][ny]].soldierNum -= dispatchCnt;
                    totalSoldierA += dispatchCnt;
                }
                // B 기준 - B 아군
                else if (findSet(idxB) == findSet(nationPosition[nx][ny])) {
                    dispatchCnt = nationInfoList[nationPosition[nx][ny]].soldierNum / 2;
                    nationInfoList[nationPosition[nx][ny]].soldierNum -= dispatchCnt;
                    totalSoldierB += dispatchCnt;
                }
            }
        }

        // 방어 성공 0 리턴
        if (totalSoldierB >= totalSoldierA) {
            nationInfoList[idxB].soldierNum = totalSoldierB - totalSoldierA;
            return 0;
        }

        // 공격 성공하면 공격지 군주는 처형
        unionList[findSet(idxB)].remove((Integer) idxB);

        // 공격지였던 영토는 동맹관계, 적대관계도 없는 새 영토가 된다.
        nationInfoList[idxB].soldierNum = totalSoldierA - totalSoldierB; // 남은 병사 결정

        // 새 군주 ID 인 nationCnt 로 정보들을 새로 입력
        nationInfoList[nationCnt] = nationInfoList[idxB];
        nationPosition[nationInfoList[nationCnt].x][nationInfoList[nationCnt].y] = nationCnt;

        // 새로운 군주 등극
        monarchHM.put(general, monarchHM.getOrDefault(general, 0) + nationCnt);

        // 동맹은 A 에 편입, 적대관계 또한 동일한다.
        parents[nationCnt] = findSet(idxA);
        unionList[findSet(idxA)].add(nationCnt);

        nationCnt++;

        return 1;
    }

    boolean isBoundary(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    int recruit(char[] mMonarch, int mNum, int mOption) {
        String monarch = charConvertToString(mMonarch);

        int recruitCnt = 0;

        if (mOption == 0) {
            int idx = monarchHM.get(monarch);
            nationInfoList[idx].soldierNum += mNum;
            recruitCnt = nationInfoList[idx].soldierNum;
        } else {
            int rootA = findSet(monarchHM.get(monarch));
            for (int allies : unionList[rootA]) {
                nationInfoList[allies].soldierNum += mNum;
                recruitCnt += nationInfoList[allies].soldierNum;
            }
        }

        return recruitCnt;
    }

    int findSet(int x) {
        if (x == parents[x]) {
            return x;
        } else {
            return parents[x] = findSet(parents[x]);
        }
    }

    void makeUnion(int x, int y) {
        x = findSet(x);
        y = findSet(y);

        // x 기준으로 몰아준다.
        if (x != y) {
            parents[y] = x;

            // x 의 동맹 리스트에 y 동맹 리스트 추가
            for (int allies : unionList[y]) {
                unionList[x].add(allies);
            }
            // x 의 적 리스트에 y 적 리스트 추가
            for (int enemy : enemyList[y]) {
                enemyList[x].add(enemy);
            }
        }
    }

    boolean isUnion(int x, int y) {
        x = findSet(x);
        y = findSet(y);

        return x == y;
    }

    boolean isEnemy(int x, int y) {
        x = findSet(x);
        y = findSet(y);

        for (int enemy : enemyList[x]) {
            if (findSet(enemy) == y) {
                return true;
            }
        }

        return false;
    }

    void makeEnemy(int x, int y) {
        x = findSet(x);
        y = findSet(y);

        if (x == y || isEnemy(x, y)) {
            return;
        }

        enemyList[x].add(y);
        enemyList[y].add(x);
    }

    String charConvertToString(char[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '\0') {
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }
}