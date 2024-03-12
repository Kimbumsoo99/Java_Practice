package swea.tbd.n14616;

import java.util.Scanner;
import java.util.TreeMap;

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
    int N, L;
    TreeMap<Player, Object>[] treeSets;

    void init(int N, int L, int mAbility[]) {
        this.N = N;
        this.L = L;
        this.LPerN = N / L;
        treeSets = new TreeMap[L];
        for (int i = 0; i < L; i++) {
            treeSets[i] = new TreeMap<>();
        }
        for (int i = 0; i < N; i++) {
            treeSets[i / LPerN].put(new Player(i, mAbility[i]), null);
        }
    }

    /**
     *
     * @return 선수들의 ID 값 합
     */
    int move() {
        int sum = 0;
        Player[][] swap = new Player[L][2];
        // 1. 모든 PriorityQueue에 대하여 값을 poll 한다.
        // 2. 모든 pqs에서 첫번째 원소와 마지막 원소에 대하여 저장한다.
        for (int i = 0; i < L; i++) {
            Player first = treeSets[i].firstKey();
            Player last = treeSets[i].lastKey();
            swap[i][0] = first;
            swap[i][1] = last;
        }

        for (int i = 0; i < L - 1; i++) {
            treeSets[i].remove(swap[i][1]);
            treeSets[i + 1].remove(swap[i + 1][0]);
            treeSets[i].put(swap[i + 1][0], null);
            treeSets[i + 1].put(swap[i][1], null);
            sum += swap[i][1].idx;
            sum += swap[i + 1][0].idx;
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
        Player[][] swap = new Player[L][2];
        // 1. 모든 PriorityQueue에 대하여 값을 poll 한다.
        // 2. 모든 pqs에서 첫번째 원소와 마지막 원소에 대하여 저장한다.
        for (int i = 0; i < L; i++) {
            Player first = treeSets[i].firstKey();
            Player midPlayer = null;
            int idx = 0;
            for (Player p : treeSets[i].keySet()) {
                if (++idx == mid) {
//					System.out.println(p);
                    midPlayer = p;
                    break;
                }
            }
            swap[i][0] = first;
            swap[i][1] = midPlayer;
        }

        for (int i = 0; i < L - 1; i++) {
            treeSets[i].remove(swap[i][1]);
            treeSets[i + 1].remove(swap[i + 1][0]);
            treeSets[i].put(swap[i + 1][0], null);
            treeSets[i + 1].put(swap[i][1], null);
            sum += swap[i][1].idx;
            sum += swap[i + 1][0].idx;
        }
        return sum;
    }

}