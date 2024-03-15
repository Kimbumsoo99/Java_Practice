package swea.tbd.n13469;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Solution
{
    private final static int CMD_INIT       = 100;
    private final static int CMD_INSERT     = 200;
    private final static int CMD_MOVECURSOR = 300;
    private final static int CMD_COUNT      = 400;

    private final static UserSolution usersolution = new UserSolution();

    private static void String2Char(char[] buf, String str, int maxLen)
    {
        for (int k = 0; k < str.length(); k++)
            buf[k] = str.charAt(k);

        for (int k = str.length(); k <= maxLen; k++)
            buf[k] = '\0';
    }

    private static char[] mStr = new char[90001];

    private static boolean run(BufferedReader br) throws Exception
    {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int queryCnt = Integer.parseInt(st.nextToken());
        boolean correct = false;

        for (int q = 0; q < queryCnt; q++)
        {
            st = new StringTokenizer(br.readLine(), " ");

            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == CMD_INIT)
            {
                int H = Integer.parseInt(st.nextToken());
                int W = Integer.parseInt(st.nextToken());

                String2Char(mStr, st.nextToken(), 90000);

                usersolution.init(H, W, mStr);
                correct = true;
            }
            else if (cmd == CMD_INSERT)
            {
                char mChar = st.nextToken().charAt(0);

                usersolution.insert(mChar);
            }
            else if (cmd == CMD_MOVECURSOR)
            {
                int mRow = Integer.parseInt(st.nextToken());
                int mCol = Integer.parseInt(st.nextToken());

                char ret = usersolution.moveCursor(mRow, mCol);

                char ans = st.nextToken().charAt(0);
                if (ret != ans)
                {
                    correct = false;
                }
            }
            else if (cmd == CMD_COUNT)
            {
                char mChar = st.nextToken().charAt(0);

                int ret = usersolution.countCharacter(mChar);

                int ans = Integer.parseInt(st.nextToken());
                if (ret != ans)
                {
                    correct = false;
                }
            }
        }
        return correct;
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

class UserSolution
{

    int maxH, maxW; // 메모장의 최대 높이, 너비
    ArrayDeque<Character>[] memo; // 메모장의 한 줄을 나타내는 deque 배열
    int h; // 현재 남긴 메모의 높이
    int curX, curY; // 커서 위치
    int[][] charCount; // 각 줄의 문자 개수 저장

    void init(int H, int W, char mStr[])
    {
        maxH = H;
        maxW = W;

        memo = new ArrayDeque[H];
        for (int i = 0; i < H; i++) {
            memo[i] = new ArrayDeque<>();
        }

        charCount = new int[maxH]['z' - 'a' + 1];

        int h = 0, w, idx = 0;
        while(h < H) {
            w = 0;
            while(w < W) {
                if(mStr[idx] == '\0') break;
                memo[h].addLast(mStr[idx]);
                charCount[h][mStr[idx] - 'a']++;
                idx++; w++;
            }

            if(mStr[idx] == '\0') break;
            h++;
        }

        this.h = h + 1;

        curX = 0; curY = 0;
    }

    void insert(char mChar)
    {
        ArrayDeque<Character> tmpDq = new ArrayDeque<>();

        // curX번째 라인에서 커서 앞의 문자들은 임시 큐에 담아줌
        for (int i = 0; i < curY; i++) {
            tmpDq.addLast(memo[curX].pollFirst());
        }

        // 새로 추가해야할 문자를 추가함
        memo[curX].addFirst(mChar);
        charCount[curX][mChar - 'a']++;

        // 임시로 담아주었던 문자들을 원래 순서대로 다시 curX 라인에 넣어줌
        while(!tmpDq.isEmpty()) memo[curX].addFirst(tmpDq.pollLast());

        // curX 라인의 문자 개수가 maxW개 이하라면 커서 위치만 바꿔주고 리턴
        if(memo[curX].size() <= maxW) {
            curY++;
            return;
        }

        // 새로운 줄이 생겨야 한다면, 현재 메모 높이 높여줌
        if(memo[h - 1].size() == maxW) h++;

        // 문자 개수가 너비를 초과했다면, 한 문자씩 뒷 줄로 미뤄줌
        char tmpC = memo[curX].pollLast();
        charCount[curX][tmpC - 'a']--;
        for (int i = curX + 1; i < h - 1; i++) {
            memo[i].addFirst(tmpC);
            charCount[i][tmpC - 'a']++;
            tmpC = memo[i].pollLast();
            charCount[i][tmpC - 'a']--;
        }
        memo[h - 1].addFirst(tmpC);
        charCount[h - 1][tmpC - 'a']++;

        // 커서 위치 조정
        if(curY == maxW) {
            curX++;
            curY = 1;
        } else curY++;
    }

    char moveCursor(int mRow, int mCol)
    {
        // mRow행 mCol열이 비어 있는 경우
        if(h < mRow || (h == mRow && memo[h - 1].size() < mCol - 1)) {
            // 커서의 위치를 문자열의 마지막 문자 오른쪽으로 이동
            curX = h - 1;
            curY = memo[h - 1].size();

            return '$';
        }

        // 커서 이동
        curX = mRow - 1;
        curY = mCol - 1;

        // 커서의 다음 문자 리턴
        char ret;
        ArrayDeque<Character> tmpDq = new ArrayDeque<>();

        // 커서 앞 문자들 임시 큐에 저장
        for (int i = 0; i < curY; i++) {
            tmpDq.addLast(memo[curX].pollFirst());
        }
        // 커서 다음 문자 저장
        ret = memo[curX].pollFirst();
        // 커서 다음 문자 다시 메모장에 저장
        memo[curX].addFirst(ret);
        // 임시로 저장해뒀던 문자들 다시 메모장에 저장
        while(!tmpDq.isEmpty()) memo[curX].addFirst(tmpDq.pollLast());

        return ret;
    }

    int countCharacter(char mChar)
    {
        int ret = 0;

        // 현재 커서가 있는 라인에서 mChar의 개수 구하기
        ArrayDeque<Character> tmpDq = new ArrayDeque<>();
        char tmpC;
        for (int i = memo[curX].size(); i > curY ; i--) {
            tmpC = memo[curX].pollLast();
            if(tmpC == mChar) ret++;
            tmpDq.addFirst(tmpC);
        }
        while(!tmpDq.isEmpty()) memo[curX].addLast(tmpDq.pollFirst());

        // 커서가 있는 다음 라인부터 마지막 라인까지 mChar의 개수 구하기
        for (int i = curX + 1; i < h; i++) {
            ret += charCount[i][mChar - 'a'];
        }

        return ret;
    }
}