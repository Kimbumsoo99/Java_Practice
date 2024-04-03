package baekjoon.implementations.gold.g17143;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 1번 낙찰
// 1. ArrayList로 상어를 저장하고, index를 Graph에 저장하는 방법 -> 상어 제거 후에 index는?
// 1-1. 상어를 저장하는 배열 인덱스로 구분
// 1-2. 움직일 상어를 저장하는 deque를 통해 하나씩 뽑아서 이동
// 1-3. 이동 후에 상어 위치에 새로운 map에 인덱스 박기.
// 1-4. 만약 이동하고자 하는 위치에 상어가 존재한다면, size 비교 후 더 큰값을 지정
// 1-5. dead Flag를 통해서 확인하기?

// 2. Shark로 Graph를 생성하는 방법 -> 별로일듯
// 3. 각각의 Shark를 따로 움직이는 방법 -> 제일 맘에들지만, 겹치는 상어 판단은 어케할까?

class Shark {
    int r, c, speed, dir, size, idx;
    boolean deadFlag;

    public Shark(int r, int c, int speed, int dir, int size, int idx, boolean deadFlag) {
        super();
        this.r = r;
        this.c = c;
        this.speed = speed;
        this.dir = dir;
        this.size = size;
        this.idx = idx;
        this.deadFlag = deadFlag;
    }

    @Override
    public String toString() {
        return "Shark [r=" + r + ", c=" + c + ", speed=" + speed + ", dir=" + dir + ", size=" + size + ", idx=" + idx
                + ", deadFlag=" + deadFlag + "]";
    }

}

public class Main {
    static int N, M, K, Graph[][];
    static int[] dx = { 0, 0, 1, -1 }, dy = { -1, 1, 0, 0 };
    static Shark[] sharks = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Graph = new int[N][M];
        sharks = new Shark[K + 1];
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            if (d < 2) { // 상어가 위, 아래로 움직인다면
                s = s % (2 * (N - 1)); // N*2 이상 움직일 필요 없음 -> 어처피 제자리로 돌아옴
            } else {
                s = s % (2 * (M - 1));
            }
            Graph[r][c] = i;
            sharks[i] = new Shark(r, c, s, d, z, i, false);
        }

        // 사람 이동
        int sumSize = 0; // 사람이 낚은 상어의 Size 합
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (Graph[j][i] != 0) {
                    Shark get = sharks[Graph[j][i]];
                    sumSize += get.size;
                    get.deadFlag = true;
                    Graph[j][i] = 0;
                    break;
                }
            }
            // 안죽은 상어를 모두 이동
            ArrayDeque<Shark> dq = new ArrayDeque<>();
            for (int j = 1; j < K + 1; j++) {
                if (!sharks[j].deadFlag) {
                    dq.offer(sharks[j]);
                }
            }
            // 살아있는 상어 모두 움직이기
            moveShark(dq);
        }
        System.out.println(sumSize);
    }

    static void moveShark(ArrayDeque<Shark> dq) {
        Graph = new int[N][M];
        while (!dq.isEmpty()) {
            Shark tmp = dq.pollFirst();
            int nr = tmp.r;
            int nc = tmp.c;
            for (int i = 1; i <= tmp.speed; i++) {
                nr += dy[tmp.dir];
                nc += dx[tmp.dir];
                if (!isMap(nr, nc)) {
                    tmp.dir = turn(tmp.dir);
                    nr += (dy[tmp.dir] * 2);
                    nc += (dx[tmp.dir] * 2);
                }
            }
            tmp.r = nr;
            tmp.c = nc;
            if (Graph[nr][nc] == 0) {
                Graph[nr][nc] = tmp.idx;
            } else if (sharks[Graph[nr][nc]].size < tmp.size) {
                sharks[Graph[nr][nc]].deadFlag = true;
                Graph[nr][nc] = tmp.idx;
            } else {
                tmp.deadFlag = true;
            }
        }
    }

    static int turn(int dir) {
        if (dir == 0)
            return 1;
        if (dir == 1)
            return 0;
        if (dir == 2)
            return 3;
        if (dir == 3)
            return 2;
        return -1;
    }

    static boolean isMap(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
