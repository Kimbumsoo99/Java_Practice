package baekjoon.algorithm.sliding_window.g15961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, c, k, d, arr[];
    static int[] visit = new int[3001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 슬라이딩 윈도우 변수
        int start = 0;
        int end = k;

        // cnt -> 다른 초밥 번호의 개수, 초기 상태 1은 COUPON 초밥 번호
        int cnt = 1;
        visit[c] += 1; // 먹은 초밥 접시 수 만큼 +
        for (int i = start; i < end; i++) {
            if (visit[arr[i]] == 0) {
                cnt++;
            }
            visit[arr[i]]++;
        }

        int answer = cnt;
        while (start < N-1) { // 슬라이딩 윈도우 시작
            if(answer <= cnt){
                if(visit[c] == 0){
                    answer = cnt+1;
                }else {
                    answer = cnt;
                }
            }
            // 슬라이딩 윈도우가 한 칸 증가하기 전, 현재 초밥 접시 제거
            visit[arr[start]]--;
            if (visit[arr[start]] == 0) { // 감소한 이후 0이 된 경우 -> 슬라이딩 윈도우에 존재하지 않음
                cnt--;
            }

            // 다음 초밥 접시 증가
            if (visit[arr[end % N]] == 0) { // 선택되지 않았던 초밥 증가 시 - >슬라이딩 윈도우 범위에 추가
                cnt++;
            }
            visit[arr[end % N]]++;

            answer = Math.max(answer, cnt); // 정답 변수 비교
            end++;
            start++;
        }
        System.out.println(answer);
    }
}
