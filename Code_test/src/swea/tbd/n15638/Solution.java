package swea.tbd.n15638;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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


class Nation{
    String king;
    int y, x, soldiers, teamId;

    public Nation(String king, int y, int x, int soldiers, int teamId) {
        this.king = king;
        this.y = y;
        this.x = x;
        this.soldiers = soldiers;
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "Nation{" +
            "king='" + king + '\'' +
            ", y=" + y +
            ", x=" + x +
            ", soldiers=" + soldiers +
            ", teamId=" + teamId +
            '}';
    }
}
class UserSolution {
    int N;
    // 동맹 관계를 저장하는 Map
    HashMap<Integer, HashSet<String>> team; // 팀 Id, 팀원 이름
    // 적대 관계를 저장하는 Map
    HashMap<Integer, HashSet<Integer>> enemy; // 팀 Id, 적대 팀 ID
    // 본인의 땅을 저장하는 Graph와 HashMap
    HashMap<String, Nation> areaMap;
    Nation[][] map;
    int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1}, dy = {-1, -1, -1, 0, 0, 1, 1, 1};

    void init(int N, int mSoldier[][], char mMonarch[][][]) {
        this.N = N; // N * N 영토
        map = new Nation[N][N];
        team = new HashMap<>();
        enemy = new HashMap<>();
        areaMap = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String monarch = charConvertToString(mMonarch[i][j]);
                map[i][j] = new Nation(monarch, i, j, mSoldier[i][j], idx);
                areaMap.put(monarch, map[i][j]);
                team.put(idx, new HashSet<>());
                team.get(idx).add(monarch);
                enemy.put(idx, new HashSet<>());
                idx++;
            }
        }
    }
    String charConvertToString(char[] c){
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (c[idx] != '\0') {
            sb.append(c[idx++]);
        }
        return sb.toString();
    }

    void destroy() {

    }

    int ally(char mMonarchA[], char mMonarchB[]) {
        String monarchA = charConvertToString(mMonarchA);
        String monarchB = charConvertToString(mMonarchB);
        Nation A = areaMap.get(monarchA);
        Nation B = areaMap.get(monarchB);
        Iterator<String> it;
//        System.out.println(A);
//        it = enemy.get(A.teamId).iterator();
//        while (it.hasNext()) {
//            System.out.print(it.next() + "\t");
//        }
//        System.out.println();
//        System.out.println(B);
//        it = enemy.get(B.teamId).iterator();
//        while (it.hasNext()) {
//            System.out.print(it.next() + "\t");
//        }
//        System.out.println();

        if (A.teamId == B.teamId) {
            return -1;
        } else if (enemy.get(A.teamId).contains(B.teamId)) {
            return -2;
        }

        Nation smallId = A;
        Nation bigId = B;
        if (B.teamId < A.teamId) {
            smallId = B;
            bigId = A;
        }

        it = team.get(bigId.teamId).iterator();
        while (it.hasNext()) {
            team.get(smallId.teamId).add(it.next());
        }
//        Iterator<Integer> enemyTeamIt = enemy.get(bigId.teamId).iterator();
//        while (enemyTeamIt.hasNext()) {
//            enemy.get(smallId.teamId).add(enemyTeamIt.next());
//        }
        Iterator<Integer> enemyIt = enemy.keySet().iterator();
        while (enemyIt.hasNext()) {
            HashSet<Integer> set = enemy.get(enemyIt.next());
            if (set.contains(bigId.teamId)) {
                set.remove(bigId.teamId);
                set.add(smallId.teamId);
            }
        }
        team.remove(bigId.teamId);
        enemy.remove(bigId.teamId);

        bigId.teamId = smallId.teamId;
        it = team.get(smallId.teamId).iterator();
        while (it.hasNext()) {
            areaMap.get(it.next()).teamId = smallId.teamId;
        }
        System.out.println("UserSolution.ally : " + team.get(smallId.teamId) + " " + enemy.get(smallId.teamId));
        return 1;
    }

    int attack(char mMonarchA[], char mMonarchB[], char mGeneral[]) {
        String monarchA = charConvertToString(mMonarchA);
        String monarchB = charConvertToString(mMonarchB);
        Nation A = areaMap.get(monarchA);
        Nation B = areaMap.get(monarchB);
        if (A.teamId == B.teamId) {
            return -1;
        }

        int currentY = B.y;
        int currentX = B.x;
        boolean flag = false;
        int sumEnemy = 0;
        int sumTeam = B.soldiers;
        for (int i = 0; i < dx.length; i++) {
            int nextY = currentY + dy[i];
            int nextX = currentX + dx[i];
            if (!isMap(nextY, nextX)) {
                continue;
            }

            if (map[nextY][nextX].teamId == A.teamId) {
//                System.out.println(map[nextY][nextX]);
                flag = true;
//                System.out.println("enemy 병사의 수 : " + (map[nextY][nextX].soldiers / 2));
                sumEnemy += map[nextY][nextX].soldiers / 2;
            } else if (map[nextY][nextX].teamId == B.teamId) {
//                System.out.println(map[nextY][nextX]);
                sumTeam += map[nextY][nextX].soldiers / 2;
//                System.out.println("team 병사의 수 : " + (map[nextY][nextX].soldiers / 2));
            }
        }
        if (!flag) {
            return -2;
        }

        for (int i = 0; i < dx.length; i++) {
            int nextY = currentY + dy[i];
            int nextX = currentX + dx[i];
            if (!isMap(nextY, nextX)) {
                continue;
            }
            if (map[nextY][nextX].teamId == A.teamId) {
                map[nextY][nextX].soldiers /= 2;
            } else if (map[nextY][nextX].teamId == B.teamId) {
                map[nextY][nextX].soldiers /= 2;
            }
        }

        System.out.println(sumEnemy + " <- Enemy | Team -> " + sumTeam);
        System.out.println(A + "\n" + B);
        // 전투 발생 적대 관계 지정
        enemy.get(A.teamId).add(B.teamId);
        enemy.get(B.teamId).add(A.teamId);

        if (sumEnemy > sumTeam) { // 공격 성공
            String general = charConvertToString(mGeneral);
            map[currentY][currentX] = new Nation(general, currentY, currentX,
                sumEnemy - sumTeam, A.teamId);
            areaMap.remove(monarchB);
            areaMap.put(general, map[currentY][currentX]);
            team.get(B.teamId).remove(monarchB);
            return 1;
        } else { // 공격 실패
            B.soldiers = sumTeam - sumEnemy;
            return 0;
        }
    }

    int recruit(char mMonarch[], int mNum, int mOption) {
        String monarchA = charConvertToString(mMonarch);
        Nation A = areaMap.get(monarchA);
        if (mOption == 0) {
            A.soldiers += mNum;
            return A.soldiers;
        }
        System.out.println(A);

        System.out.println("UserSolution.recruit : " + team.get(A.teamId));
        // 1인 경우
        Iterator<String> it = team.get(A.teamId).iterator();
        int sum = 0;
        while (it.hasNext()) {
            Nation tmp = areaMap.get(it.next());
            tmp.soldiers += mNum;
            sum += tmp.soldiers;
        }
        return sum;
    }

    boolean isMap(int y, int x){
        return y >= 0 && x >= 0 && y < N && x < N;
    }
}