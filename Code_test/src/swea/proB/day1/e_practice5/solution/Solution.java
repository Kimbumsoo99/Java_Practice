package swea.proB.day1.e_practice5.solution;

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
}

class Team {
    Node[] head = new Node[6];
    Node[] tail = new Node[6];
}

class UserSolution {
    public Node[] nodes = new Node[200055];
    public int cnt = 0;
    public int[] version = new int[100055];  // version[i] := ID 가 i 인 사람의 최신 버전
    public int[] teamNum = new int[100055];      // num[i] := ID 가 i 인 사람의 team 번호

    public Node getNewNode(int id, Node nxt) {
        Node ret = nodes[cnt++];
        ret.idx = id;
        ret.next = nxt;
        ret.ver = ++version[id];
        return ret;
    }


    public Team[] team = new Team[6];

    public void init() {
        cnt = 0;
        for (int i = 0; i < 200055; i++) {
            if (nodes[i] == null) nodes[i] = new Node();
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

    public void hire(int mID, int mTeam, int mScore) {  // O(1)
        Node newNode = getNewNode(mID, null);
        team[mTeam].tail[mScore].next = newNode;
        team[mTeam].tail[mScore] = newNode;
        teamNum[mID] = mTeam;
    }

    public void fire(int mID) {  // O(1)
        version[mID] = -1;
    }

    public void updateSoldier(int mID, int mScore) {  // O(1)
        hire(mID, teamNum[mID], mScore);
    }

    public void updateTeam(int mTeam, int mChangeScore) {  // O(1)
        if (mChangeScore < 0) {
            for (int j = 1; j <= 5; j++) {
                int k = j + mChangeScore;
                k = k < 1 ? 1 : (k > 5 ? 5 : k);
                if (j == k) continue;

                if (team[mTeam].head[j].next == null) continue;
                team[mTeam].tail[k].next = team[mTeam].head[j].next;
                team[mTeam].tail[k] = team[mTeam].tail[j];
                team[mTeam].head[j].next = null;
                team[mTeam].tail[j] = team[mTeam].head[j];
            }
        }
        if (mChangeScore > 0) {
            for (int j = 5; j >= 1; j--) {
                int k = j + mChangeScore;
                k = k < 1 ? 1 : (k > 5 ? 5 : k);
                if (j == k) continue;

                if (team[mTeam].head[j].next == null) continue;
                team[mTeam].tail[k].next = team[mTeam].head[j].next;
                team[mTeam].tail[k] = team[mTeam].tail[j];
                team[mTeam].head[j].next = null;
                team[mTeam].tail[j] = team[mTeam].head[j];
            }
        }
    }

    public int bestSoldier(int mTeam) {  // O(N)
        for (int j = 5; j >= 1; j--) {
            Node node = team[mTeam].head[j].next;
            if (node == null) continue;

            int ans = 0;
            while (node != null) {
                if (node.ver == version[node.idx]) {
                    ans = ans < node.idx ? node.idx : ans;
                }
                node = node.next;
            }
            if (ans != 0) return ans;
        }
        return 0;
    }
}