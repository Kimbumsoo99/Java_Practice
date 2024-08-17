package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
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

        for (Meeting meeting : meetings) {
            if(pq.isEmpty()){
                
            } else if (pq.peek().endTime <= meeting.startTime) {

            }

            pq.offer(meeting);

        }



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


}