package baekjoon.data_structure.priority_queue.g19598;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    ArrayList<Meeting> meetings = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // N개의 회의를 모두 진행할 수 있는 최소 회의실 개수
        // 시작 - 끝 시간
        // 끝 == 시작이어도 가능하다.

        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            max = Math.max(max, B); // 끝나는 최대 시간
            meetings.add(new Meeting(A, B));
        }
        
        // 시작 순서대로 정렬
        Collections.sort(meetings, (o1, o2) -> {
            return o1.startTime - o2.startTime;
        });

        // 끝나는 시간 순으로 정렬하면서 빼기
        PriorityQueue<Meeting> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.endTime - o2.endTime;
        });

        // 가장 빠른시간 삽입 + 1
        // 모든 pq를 돌면서 가장 빨리 끝나는 시간 찾아보기
        // 찾았다면, 해당 pq 요소 빼고, 삽입
        // 마지막 순회를 돌고난 뒤 size() 체크
        for (Meeting meeting : meetings) {
//            System.out.printf("meetings = %s, pq.size() = %d\n", meeting.toString(), pq.size());
            if (pq.isEmpty()) {
                pq.offer(meeting);
            } else if (pq.peek().endTime <= meeting.startTime) {
                Meeting reservedMeeting = pq.poll();
                pq.offer(meeting);
            } else {
                pq.offer(meeting);
            }
        }

        System.out.println(pq.size());
    }
}

class Meeting{
    int startTime;
    int endTime;

    public Meeting(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Meeting(){}


    @Override
    public String toString() {
        return "Meeting{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}