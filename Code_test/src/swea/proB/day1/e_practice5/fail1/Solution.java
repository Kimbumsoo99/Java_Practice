package swea.proB.day1.e_practice5.fail1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
병사들을 관리하는 프로그램
병사들은 고유번호, 소속팀, 평판 점수를 지님
 1. 병사 고용
 2. 병사 해고
 3. 병사의 평판 점수 변경
 4. 특정 팀에 속한 병사들의 평판 점수를 일괄 변경
 5. 특정 팀 안에서 가장 평판 점수가 높은 병사를 검색
 */

class Soldier {
    int id;
    int teamId;
    int score;

    @Override
    public String toString() {
        return "Soldier [id=" + id + ", teamId=" + teamId + ", score=" + score + "]";
    }

    public Soldier(int id, int teamId, int score) {
        super();
        this.id = id;
        this.teamId = teamId;
        this.score = score;
    }

    public Soldier() {
    }

    void scoreAdd(int mScore) {
        this.score += mScore;
        if (this.score > 5)
            this.score = 5;
        if (this.score < 1)
            this.score = 1;
    }
}

class SoldierManager {
    HashMap<Integer, Soldier> soldiers = new HashMap<>();
    Soldier bestSoldier;

    public SoldierManager() {
        // TODO Auto-generated constructor stub
    }

    public void add(int mID, int mTeam, int mScore) {
        Soldier soldier = new Soldier(mID, mTeam, mScore);
        this.soldiers.put(mID, soldier);
        if (this.bestSoldier == null) {
            bestSoldier = soldier;
        } else {
            if (bestSoldier.score == soldier.score) {
                bestSoldier = bestSoldier.id > soldier.id ? bestSoldier : soldier;
            } else {
                bestSoldier = bestSoldier.score > soldier.score ? bestSoldier : soldier;
            }
        }
    }

    public void bestRemove() {
        soldiers.remove(bestSoldier.id);
        bestSoldier = null;
        for (Integer sid : soldiers.keySet()) {
            Soldier soldier = soldiers.get(sid);
            bestRenew(soldier);
        }
    }

    public void remove(int mID) {
        if (mID == bestSoldier.id) {
            this.bestRemove();
            return;
        }
        soldiers.remove(mID);
    }

    public void update(int mID, int mScore) {
        if (mID == bestSoldier.id && mScore < bestSoldier.score) {
            bestSoldier.score = mScore;
            for (Integer sid : soldiers.keySet()) {
                Soldier soldier = this.soldiers.get(sid);
                bestRenew(soldier);
            }
        } else {
            Soldier soldier = this.soldiers.get(mID);
            soldier.score = mScore;
            bestRenew(soldier);
        }
    }

    public void bestRenew(Soldier soldier) {
        if (this.bestSoldier == null) {
            bestSoldier = soldier;
        } else {
            if (bestSoldier.score == soldier.score) {
                bestSoldier = bestSoldier.id > soldier.id ? bestSoldier : soldier;
            } else {
                bestSoldier = bestSoldier.score > soldier.score ? bestSoldier : soldier;
            }
        }
    }

    public void update(int mScore) {
        Soldier tmp = null;
        for (Integer sid : soldiers.keySet()) {
            Soldier soldier = this.soldiers.get(sid);
            soldier.scoreAdd(mScore);
            if (tmp == null || tmp.score < soldier.score || (tmp.score == soldier.score && tmp.id < soldier.id)) {
                tmp = soldier;
            }
        }
        bestSoldier = tmp;
    }
}

class UserSolution {
    SoldierManager[] team;
    HashMap<Integer, Integer> soldierTeam;

    void init() {
        team = new SoldierManager[6];
        for (int i = 0; i < 6; i++) {
            // 팀 번호 배열TreeMap[] idx에 맞는 병사 저장
            team[i] = new SoldierManager();
        }
        soldierTeam = new HashMap<>(); // 병사 번호 -> 팀 번호 저장
    }

    /**
     * 병사 고용
     *
     * 한 테스트 케이스 내에서 동일한 mID를 가진 병사가 여러 번 고용되는 경우는 없음이 보장
     *
     * @param mID    : 고유번호 (1 ≤ mID ≤ 100,000)
     * @param mTeam  : 소속팀 (1 ≤ mTeam ≤ 5)
     * @param mScore : 평판 점수 (1 ≤ mScore ≤ 5)
     */
    void hire(int mID, int mTeam, int mScore) {
        soldierTeam.put(mID, mTeam);
        team[mTeam].add(mID, mTeam, mScore);
    }

    /**
     * mID인 병사를 해고
     *
     * fire() 함수 호출 시, 고유번호가 mID인 병사가 고용되어 있음이 보장
     *
     * @param mID : 고유번호 (1 ≤ mID ≤ 100,000)
     */
    void fire(int mID) {
        int tid = soldierTeam.get(mID);
        team[tid].remove(mID);
    }

    /**
     * 평판 점수를 mScore로 변경
     *
     * 병사가 고용되어 있음이 보장
     *
     * @param mID    : 고유번호 (1 ≤ mID ≤ 100,000)
     * @param mScore : 평판 점수 (1 ≤ mScore ≤ 5)
     */
    void updateSoldier(int mID, int mScore) {
        int tid = soldierTeam.get(mID);
        team[tid].update(mID, mScore);
    }

    /**
     * 소속팀이 mTeam인 병사들의 평판 점수를 모두 변경
     *
     * 병사가 한 명 이상 고용되어 있음이 보장
     *
     * updateTeam() 함수에서의 평판 점수 변경은 아래의 규칙에 따른다.
     *
     * ‘변경 전 평판 점수 + mChangeScore’가 5보다 클 경우, 평판 점수를 5로 변경한다.
     *
     * ‘변경 전 평판 점수 + mChangeScore’가 1보다 작을 경우, 평판 점수를 1로 변경한다.
     *
     * 그 외의 경우, 평판 점수를 ‘변경 전 평판 점수 + mChangeScore’로 변경한다.
     *
     * @param mTeam        : 소속팀 (1 ≤ mTeam ≤ 5)
     * @param mChangeScore : 평판 점수의 변화량 (-4 ≤ mChangeScore ≤ 4)
     */
    void updateTeam(int mTeam, int mChangeScore) {
        team[mTeam].update(mChangeScore);
    }

    /**
     * 평판 점수가 가장 높은 병사의 고유번호를 반환
     *
     * 여러 명일 경우, 고유번호가 가장 큰 병사의 고유번호를 반환
     *
     * @param mTeam
     * @return
     */
    int bestSoldier(int mTeam) {
        return team[mTeam].bestSoldier.id;
    }
}

class Solution
{
    private final static int CMD_INIT				= 1;
    private final static int CMD_HIRE				= 2;
    private final static int CMD_FIRE				= 3;
    private final static int CMD_UPDATE_SOLDIER		= 4;
    private final static int CMD_UPDATE_TEAM		= 5;
    private final static int CMD_BEST_SOLDIER		= 6;

    private final static UserSolution usersolution = new UserSolution();

    private static boolean run(BufferedReader br) throws Exception
    {
        StringTokenizer st;

        int numQuery;

        int mID, mTeam, mScore, mChangeScore;

        int userAns, ans;

        boolean isCorrect = false;

        numQuery = Integer.parseInt(br.readLine());

        for (int q = 0; q < numQuery; ++q)
        {
            st = new StringTokenizer(br.readLine(), " ");

            int cmd;
            cmd = Integer.parseInt(st.nextToken());

            switch(cmd)
            {
                case CMD_INIT:
                    usersolution.init();
                    isCorrect = true;
                    break;
                case CMD_HIRE:
                    mID = Integer.parseInt(st.nextToken());
                    mTeam = Integer.parseInt(st.nextToken());
                    mScore = Integer.parseInt(st.nextToken());
                    usersolution.hire(mID, mTeam, mScore);
                    break;
                case CMD_FIRE:
                    mID = Integer.parseInt(st.nextToken());
                    usersolution.fire(mID);
                    break;
                case CMD_UPDATE_SOLDIER:
                    mID = Integer.parseInt(st.nextToken());
                    mScore = Integer.parseInt(st.nextToken());
                    usersolution.updateSoldier(mID, mScore);
                    break;
                case CMD_UPDATE_TEAM:
                    mTeam = Integer.parseInt(st.nextToken());
                    mChangeScore = Integer.parseInt(st.nextToken());
                    usersolution.updateTeam(mTeam, mChangeScore);
                    break;
                case CMD_BEST_SOLDIER:
                    mTeam = Integer.parseInt(st.nextToken());
                    userAns = usersolution.bestSoldier(mTeam);
                    ans = Integer.parseInt(st.nextToken());
                    if (userAns != ans) {
                        isCorrect = false;
                    }
                    break;
                default:
                    isCorrect = false;
                    break;
            }
        }

        return isCorrect;
    }

    public static void main(String[] args) throws Exception
    {
        int TC, MARK;

        //System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        TC = Integer.parseInt(st.nextToken());
        MARK = Integer.parseInt(st.nextToken());

        for (int testcase = 1; testcase <= TC; ++testcase)
        {
            int score = run(br) ? MARK : 0;
            System.out.println("#" + testcase + " " + score);
        }

        br.close();
    }
}
