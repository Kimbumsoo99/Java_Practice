package swea.tbd.n14616;

import java.util.ArrayList;
import java.util.Collections;

import java.util.Scanner;

class Solution {
    private static Scanner sc;
    private static UserSolution usersolution = new UserSolution();

    private final static int CMD_INIT = 100;
    private final static int CMD_MOVE = 200;
    private final static int CMD_TRADE = 300;

    private static boolean run() throws Exception {

        int query_num = sc.nextInt();
        int ans;
        boolean ok = false;

        for (int q = 0; q < query_num; q++) {
            int query = sc.nextInt();

            if (query == CMD_INIT) {
                int N = sc.nextInt();
                int L = sc.nextInt();
                int mAbility[] = new int[N];
                for (int i = 0; i < N; i++){
                    mAbility[i] = sc.nextInt();
                }
                usersolution.init(N, L, mAbility);
                ok = true;
            } else if (query == CMD_MOVE) {
                int ret = usersolution.move();
                ans = sc.nextInt();
                if (ans != ret) {
                    ok = false;
                }
            } else if (query == CMD_TRADE) {
                int ret = usersolution.trade();
                ans = sc.nextInt();
                if (ans != ret) {
                    ok = false;
                }
            }
        }
        return ok;
    }

    public static void main(String[] args) throws Exception {
        int T, MARK;

        // System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
        sc = new Scanner(System.in);
        T = sc.nextInt();
        MARK = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int score = run() ? MARK : 0;
            System.out.println("#" + tc + " " + score);
        }
        sc.close();
    }
}
class Player implements Comparable<Player> {
    int idx, val;

    public Player(int idx, int val) {
        super();
        this.idx = idx;
        this.val = val;
    }

    @Override
    public int compareTo(Player o) {
        if (o.val == this.val)
            return this.idx - o.idx;
        return o.val - this.val;
    }

    @Override
    public String toString() {
        return "Player [idx=" + idx + ", val=" + val + "]";
    }

}

class UserSolution {
    int LPerN; // 리그 당 인원 수
    ArrayList<Player>[] lists;

//    public static void main(String[] args) {
//        UserSolution u = new UserSolution();
//        u.init(15, 3, new int[] { 1, 5, 6, 8, 7, 3, 2, 1, 4, 5, 9, 8, 7, 6, 1 });
//        System.out.println("Move");
//        System.out.println(u.move());
//        System.out.println(u.move());
//        System.out.println(u.trade());
//        System.out.println(u.trade());
//        System.out.println(u.move());
//        System.out.println(u.trade());
//    }

    /**
     *
     * @param N        선수들의 수
     * @param L        리그의 수
     * @param mAbility 각 선수들의 능력 값
     */
    void init(int N, int L, int mAbility[]) {
        this.LPerN = N / L;
        lists = new ArrayList[L];
        for (int i = 0; i < L; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            lists[i / LPerN].add(new Player(i, mAbility[i]));
        }
//        System.out.println("size : " + lists.length);
    }

    /**
     *
     * @return 선수들의 ID 값 합
     */
    int move() {
        int sum = 0;
        Player[][] endPoint = new Player[lists.length][2];
        // 1. 모든 PriorityQueue에 대하여 값을 poll 한다.
        // 2. 모든 pqs에서 첫번째 원소와 마지막 원소에 대하여 저장한다.
        for (int i = 0; i < lists.length; i++) {
            Collections.sort(this.lists[i]);
            Player first = lists[i].get(0);
            Player last = lists[i].get(lists[i].size() - 1);
            endPoint[i][0] = first;
            endPoint[i][1] = last;
//            System.out.println("출력 : " + Arrays.toString(endPoint[i]));
        }

        for (int i = 0; i < lists.length - 1; i++) {
            lists[i + 1].set(0, endPoint[i][1]);
            sum += endPoint[i][1].idx;
            lists[i].set(lists[i].size() - 1, endPoint[i + 1][0]);
            sum += endPoint[i + 1][0].idx;
        }

        return sum;
    }

    /**
     *
     * @return 선수들의 ID 값 합
     */
    int trade() {
        int mid = (LPerN + 1) / 2;
        int sum = 0;
        Player[][] endPoint = new Player[lists.length][2];
        // 1. 모든 PriorityQueue에 대하여 값을 poll 한다.
        // 2. 모든 pqs에서 첫번째 원소와 마지막 원소에 대하여 저장한다.
        for (int i = 0; i < lists.length; i++) {
            Collections.sort(this.lists[i]);
            Player first = lists[i].get(0);
            Player midPlayer = lists[i].get(mid - 1);
            endPoint[i][0] = first;
            endPoint[i][1] = midPlayer;
//            System.out.println("출력 : " + Arrays.toString(endPoint[i]));
        }

        for (int i = 0; i < lists.length - 1; i++) {
            lists[i + 1].set(0, endPoint[i][1]);
            sum += endPoint[i][1].idx;
            lists[i].set(mid - 1, endPoint[i + 1][0]);
            sum += endPoint[i + 1][0].idx;
        }

        return sum;
    }

}