package swea.proB.day1.c_linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 1230. [S/W 문제해결 기본] 8일차 - 암호문3
 * 연결리스트 실습
 */
class Node{
    // 암호문 뭉치
    int code, idx;
    Node next;
    Node pre;

    public Node(int code, int idx, Node next, Node pre) {
        this.code = code;
        this.idx = idx;
        this.next = next;
        this.pre = pre;
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int answer = 0;

            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int cmd = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < cmd; i++) {
                String op = st.nextToken();
                if ("I".equals(op)) {
                    int idx = Integer.parseInt(st.nextToken());
                    int cnt = Integer.parseInt(st.nextToken());
                    LinkedList<Integer> arr = new LinkedList<Integer>();
                    for (int j = 0; j < cnt; j++) {
                        arr.add(Integer.parseInt(st.nextToken()));
                    }
                    list.addAll(idx, arr);
                } else if ("A".equals(op)) {
                    int cnt = Integer.parseInt(st.nextToken());
                    LinkedList<Integer> arr = new LinkedList<Integer>();
                    for (int j = 0; j < cnt; j++) {
                        arr.add(Integer.parseInt(st.nextToken()));
                    }
                    list.addAll(arr);
                } else {
                    int idx = Integer.parseInt(st.nextToken());
                    int cnt = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < cnt; j++) {
                        list.remove(idx);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Integer code : list.subList(0, 10)) {
                sb.append(code + " ");
            }
            System.out.printf("#%d %s\n", test_case, sb.toString());
        }
    }
}

/*

            Node top = new Node(0, 0, null, null);
            st = new StringTokenizer(br.readLine());
            Node pre = top;
            for (int i = 1; i <= N; i++) {
                int code = Integer.parseInt(st.nextToken());
                Node tmp = new Node(code, i, null, pre);
                pre.next = tmp;
                pre = tmp;
            }
            pre.next = top;
            top.pre = pre;
            int index = top.pre.idx;

            int cmd = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < cmd; i++) {
                String op = st.nextToken();
                if ("I".equals(op)) {
                    int idx = Integer.parseInt(st.nextToken());
                    int cnt = Integer.parseInt(st.nextToken());
                    int arr[] = new int[cnt];
                    for (int j = 0; j < cnt; j++) {
                        arr[j] = Integer.parseInt(st.nextToken());
                    }
                } else if ("A".equals(op)) {
                    int idx = index;
                    int cnt = Integer.parseInt(st.nextToken());
                    int arr[] = new int[cnt];
                    for (int j = 0; j < cnt; j++) {
                        arr[j] = Integer.parseInt(st.nextToken());
                    }
                } else {
                    int idx = Integer.parseInt(st.nextToken());

                }
            }
 */