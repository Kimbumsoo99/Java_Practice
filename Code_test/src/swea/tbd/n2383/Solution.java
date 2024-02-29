package swea.tbd.n2383;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Person {
    int y, x, distance, no;

    public Person(int y, int x, int no) {
        super();
        this.y = y;
        this.x = x;
        this.no = no + 1;
    }

    @Override
    public String toString() {
        return "Person [y=" + y + ", x=" + x + ", distance=" + distance + ", no=" + no + "]";
    }

}

public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int N, Graph[][], person, answer = Integer.MAX_VALUE;
    static ArrayList<Person> people;
    static ArrayList<int[]> stairsList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int test_case = 1; test_case < T + 1; test_case++) {
            sb.append("#" + test_case + " ");
            N = Integer.parseInt(br.readLine());
            people = new ArrayList<>();
            person = 0;
            answer = Integer.MAX_VALUE;
            Graph = new int[N][N];
            stairsList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    Graph[i][j] = Integer.parseInt(st.nextToken());
                    if (Graph[i][j] >= 2) {
                        stairsList.add(new int[] { i, j, Graph[i][j] });
                    } else if (Graph[i][j] == 1) {
                        people.add(new Person(i, j, person++));
                    }
                }
            }
            boolean[] visit = new boolean[person];
            for (int i = 0; i < (1 << person); i++) {
                for (int j = 0; j < person; j++) {
                    if ((i & (1 << j)) != 0) {
                        visit[j] = true;
                    }
                }
                // 1. 계단 한쪽에 들어가는 부분 집합 만들기
//				if (!visit[0] && !visit[1] && visit[2] && visit[3] && visit[4] && !visit[5] && !visit[6]) {
//					System.out.println("askljdnaskjfnaskjfnaskjf");
//				}
                answer = Math.min(answer, exit(visit));
                visit = new boolean[person];
            }
            sb.append(answer + "\n");
        }
        System.out.println(sb);

    }

    static int exit(boolean visit[]) {
        // 2. 각각의 부분 집합이 계단에서 걸리는 시간 측정
        ArrayList<Person> list = new ArrayList<>();
        for (int i = 0; i < person; i++) {
            if (visit[i]) {
                list.add(people.get(i));
            }
        }
        int time = exitTime(list, 0);
        list = new ArrayList<>();
        for (int i = 0; i < person; i++) {
            if (!visit[i])
                list.add(people.get(i));
        }
        time = Math.max(time, exitTime(list, 1));
//		System.out.println("타임은 : " + time);
        return time;
    }

    static int exitTime(ArrayList<Person> list, int cmd) { // people size, 배열, 계단
        if (list.isEmpty())
            return 0;
        int[] cur = stairsList.get(cmd);
        int cY = cur[0];
        int cX = cur[1];
        for (int i = 0; i < list.size(); i++) {
            Person person = list.get(i);
            person.distance = Math.abs(cY - person.y) + Math.abs(cX - person.x);
        }
        // 3. 계단으로 부터 가까운 사람 순으로 정렬하기
        // 3-1. |사람-계단| + |사람-계단|의 거리가 가장 짧은 순
        Collections.sort(list, (o1, o2) -> {
            return o1.distance - o2.distance;
        });
//		System.out.println("계단 : " + cmd + ", List : " + list);
        ArrayDeque<Person> dq = new ArrayDeque<>();
        int time = list.get(0).distance;
        // 1. 가장 짧은 거리 값 가져오기
        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
            // 2. 모든 index 비상구까지 이동
            list.get(i).distance -= time;
            if (list.get(i).distance == 0 && dq.size() < 3) {
                idx++;
                dq.offer(list.get(i));
            }
        }
//		System.out.println(time);
        while (true) {
            time++;
            int size = dq.size();
            while (size-- > 0) {
                if (--dq.peek().distance < -Graph[cY][cX]) {
                    // dq에서 시간이 흘렀을 때, 계단을 다 내려갔다면
                    dq.pollFirst();
                    if (idx < list.size() && list.get(idx).distance == 0) {
                        list.get(idx).distance--;
                        dq.offer(list.get(idx++));
                    }
//					System.out.println(time + " " + dq.pollFirst());
                } else {
                    dq.offer(dq.pollFirst());
                }
            }
            for (int i = idx; i < list.size(); i++) {
                if (list.get(i).distance > 0)
                    list.get(i).distance--;
                if (list.get(i).distance == 0 && (dq.size() < 3)) {
                    dq.offer(list.get(i));
                    idx++;
                }
            }
//			System.out.println(dq.size() + " " + time);
            if (idx == list.size() && dq.isEmpty()) {
                break;
            }
        }
        return time;
    }
}
