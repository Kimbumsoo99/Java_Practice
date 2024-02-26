package baekjoon.greedy.g2457;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


/*
 * 참여할 수 있는 N개의 프로젝트
 * 프로젝트의 시작일과 종료일은 정해져 있다.
 * 5월 25일에 끝나는 것은 24일까지 진행
 *
 * 조건
 * 1. 3월 1일부터 11월 30일까지 매일 한가지 이상의 프로젝트에 참여
 * 2. 참여하는 프로젝트의 수를 가능한 적게한다.
 *
 * 프로젝트가 겹치지 않는 날짜가 최대가 되도록 구하자.
 *
 * 풀이 방식
 * 시작 날짜순 정렬
 * 3월 1일 이전에 시작하는 날짜 중 가장 프로젝트가 종료 날짜가 긴 프로젝트 선택 (Idx 기억)
 * Idx 이전에 시작하는 날짜 중 가장 프로젝트 종료 날짜가 긴 프로젝트 선택
 * 11월 30일을 넘겼다면 true
 */

public class Main {
    static class Project implements Comparable<Project>{
        int sMonth, sDay, fMonth, fDay;
        int diff;

        public Project(int sMonth, int sDay, int fMonth, int fDay) {
            super();
            this.sMonth = sMonth;
            this.sDay = sDay;
            this.fMonth = fMonth;
            this.fDay = fDay;
            diff();
        }

        void diff() {
            this.diff = sumMonthDay[(fMonth - 1) - (sMonth - 1)] + (fDay - sDay);
        }

        public int compareTo(Project o) {
            if(this.sMonth == o.sMonth) {
                if(this.sDay == o.sDay) {
                    return o.diff - this.diff;
                }
                return this.sDay - o.sDay;
            }
            return this.sMonth - o.sMonth;
        }

        @Override
        public String toString() {
            return "Project [sMonth=" + sMonth + ", sDay=" + sDay + ", fMonth=" + fMonth + ", fDay=" + fDay + ", diff="
                + diff + "]";
        };
    }
    static StringBuilder sb = new StringBuilder();
    static int[] monthDay = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] sumMonthDay = new int[13];
    static ArrayList<Project> list = new ArrayList<>();
    static int pjt = 0;
    static Project current = new Project(3, 1, 3, 1);
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        sumMonthDayInit();
//		System.out.println(Arrays.toString(sumMonthDay));
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sMonth = Integer.parseInt(st.nextToken());
            int sDay = Integer.parseInt(st.nextToken());
            int fMonth = Integer.parseInt(st.nextToken());
            int fDay = Integer.parseInt(st.nextToken());
            list.add(new Project(sMonth, sDay, fMonth, fDay));
        }
        Collections.sort(list);
        // 의문점 11월 30일에 끝나는 경우는 11월 30일까지에 포함인가? 12월 1
        while(getDayDiff(current.fMonth, current.fDay, 12, 1) > 0) {
//			System.out.println(current);
            int lastDiff = 0;
            int lastIdx = -1;
            for (int i = 0; i < list.size(); i++) {
                Project tmp = list.get(i);
                if(getDayDiff(tmp.sMonth, tmp.sDay, current.fMonth, current.fDay) >= 0) {
                    int tmpDiff = getDayDiff(current.fMonth, current.fDay, tmp.fMonth, tmp.fDay);
                    if(lastDiff < tmpDiff) {
                        lastDiff = tmpDiff;
                        lastIdx = i;
                    }
                }else {
                    break;
                }
            }
            if(lastDiff == 0 && lastIdx == -1) {
                System.out.println(0);
                return;
            }
            pjt++;
            current = list.get(lastIdx);
//			System.out.println("next : " + current);
        }
        System.out.println(pjt);
    }
    static void sumMonthDayInit() {
        for (int i = 1; i < monthDay.length; i++) {
            sumMonthDay[i] = sumMonthDay[i-1] + monthDay[i];
        }
    }

    static int getDayDiff(int sM, int sD, int pSM, int pSD) { // 뒷 인자가 큰 경우 + Diff 반환, 작은 경우 - Diff 반환
        int returnValue = sumMonthDay[pSM - 1] + pSD;
        returnValue -= sumMonthDay[sM - 1] + sD;
        return returnValue;
    }
}
