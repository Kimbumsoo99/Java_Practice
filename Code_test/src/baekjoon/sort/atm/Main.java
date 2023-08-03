package baekjoon.sort.atm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 그리디, 정렬 문제인데 우선순위 큐로 풀었음
// 다른 풀이 참고해야함
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        int answer = 0;
        int sum = 0;
        Integer[] tmpArr = new Integer[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                tmpArr[j] = pq.poll();
                sum += tmpArr[j];
//                System.out.println(tmpArr[j] + " " + sum + " " + answer);
            }
            for (int j = 0; j <= i; j++) {
                pq.offer(tmpArr[j]);
            }
            answer += sum;
            sum = 0;
        }
        System.out.println(answer);
    }
}
