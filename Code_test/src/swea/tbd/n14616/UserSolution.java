package swea.tbd.n14616;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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

public class UserSolution {
    int LPerN; // 리그 당 인원 수
    ArrayList<Player>[] lists;

    public static void main(String[] args) {
        UserSolution u = new UserSolution();
        u.init(15, 3, new int[] { 1, 5, 6, 8, 7, 3, 2, 1, 4, 5, 9, 8, 7, 6, 1 });
        System.out.println("Move");
        System.out.println(u.move());
    }

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
        System.out.println("size : " + lists.length);
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
            System.out.println("출력 : " + Arrays.toString(endPoint[i]));
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

        return 0;
    }

}