package swea.proB.day1.e_practice5.solution2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
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
class Node {
    int idx;
    int ver;
    Node next;

    Node() {
    }

    Node(int idx, int ver) {
        this.idx = idx;
        this.ver = ver;
        this.next = null;
    }

    Node(int idx, int ver, Node next) {
        this.idx = idx;
        this.ver = ver;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node [idx=" + idx + ", ver=" + ver + ", next=" + next + "]";
    }

}

class Team {
    Node[] head;
    Node[] tail;

    public Team() {
        head = new Node[6];
        tail = new Node[6];
    }
}

class UserSolution {
    Node[] nodes = new Node[200055]; // 새로 생성된 Node
    int cnt = 0;
    int[] version = new int[100055]; // node idx에 해당되는 version 정보
    int[] teamNum = new int[100055]; // id에 해당하는 팀 번호
    Team[] team = new Team[6];

    public Node getNewNode(int idx, Node next) {
        Node ret = nodes[cnt++];
        ret.idx = idx;
        ret.next = next;
        ret.ver = ++version[idx];
        return ret;
    }

    void init() {
        cnt = 0;
        for (int i = 0; i < 200055; i++) {
            if (nodes[i] == null)
                nodes[i] = new Node();
        }
        for (int i = 1; i <= 5; i++) {
            team[i] = new Team();
            for (int j = 1; j <= 5; j++) {
                team[i].tail[j] = team[i].head[j] = getNewNode(0, null);
            }
        }

        for (int i = 0; i <= 100000; i++) {
            version[i] = 0;
            teamNum[i] = 0;
        }
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
        Node node = getNewNode(mID, null);
        team[mTeam].tail[mScore].next = node;
        team[mTeam].tail[mScore] = node;
        teamNum[mID] = mTeam;
    }

    /**
     * mID인 병사를 해고
     *
     * fire() 함수 호출 시, 고유번호가 mID인 병사가 고용되어 있음이 보장
     *
     * @param mID : 고유번호 (1 ≤ mID ≤ 100,000)
     */
    void fire(int mID) {
        version[mID] = -1;
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
        hire(mID, teamNum[mID], mScore);
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
        if (mChangeScore < 0) {
            for (int i = 1; i <= 5; i++) {

                // i는 기존 스코어 연결리스트
                // s는 업데이트 될 스코어 연결리스트

                // s의 tail.next를 i의 head.next로 변경
                // s의 tail을 i의 tail로 변경
                // i의 head.next를 null로 변경 (기존 스코어 head가 사라짐)
                // i의 tail = i의 head로 변경
                int s = i + mChangeScore;
                s = s < 1 ? 1 : s;

                if (s == i)
                    continue;
                if (team[mTeam].head[i].next == null)
                    continue;
                team[mTeam].tail[s].next = team[mTeam].head[i].next;
                team[mTeam].tail[s] = team[mTeam].tail[i];
                team[mTeam].head[i].next = null;
                team[mTeam].tail[i] = team[mTeam].head[i];
            }
        } else {
            for (int i = 5; i >= 1; i--) {
                int s = i + mChangeScore;
                s = s > 5 ? 5 : s;
                if (s == i)
                    continue;
                if (team[mTeam].head[i].next == null)
                    continue;
                team[mTeam].tail[s].next = team[mTeam].head[i].next;
                team[mTeam].tail[s] = team[mTeam].tail[i];
                team[mTeam].head[i].next = null;
                team[mTeam].tail[i] = team[mTeam].head[i];
            }
        }
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
        for (int i = 5; i >= 1; i--) {
            Node node = team[mTeam].head[i].next;
            if (node == null)
                continue;

            int ans = 0;
            while (node != null) {
//				System.out.println(node + " " + version[node.idx]);
                if (node.ver == version[node.idx])
                    ans = ans < node.idx ? node.idx : ans;
                node = node.next;
            }
            if (ans != 0)
                return ans;
        }
        return 0;
    }
}


public class Solution
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