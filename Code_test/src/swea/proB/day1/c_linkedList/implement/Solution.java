package swea.proB.day1.c_linkedList.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 1230. [S/W 문제해결 기본] 8일차 - 암호문3
 * 연결리스트 구현
 */
class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    final int NODE_MAX = 5000;
    Node[] arr;
    Node head, tail;
    int cnt;

    public LinkedList() {
        head = null;
        arr = new Node[NODE_MAX];
        cnt = 0;
    }

    Node newNode(int data){
        arr[cnt] = new Node(data);
        return arr[cnt++];
    }

    void insert(int idx, int len, int[] dataArr){
        int start = 0;
        if (idx == 0) {
            if (head == null) {
                head = newNode(dataArr[0]);
            }else{
                Node tmp = newNode(dataArr[0]);
                tmp.next = head;
                head = tmp;
            }
            start = 1;
        }

        Node cur = head;
        for (int i = 1; i < idx; i++) {
            cur = cur.next;
        }

        for (int i = start; i < len; i++) {
            Node newNode = newNode(dataArr[i]);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode;
        }
        if (tail == null) {
            tail = cur;
        }
    }

    void delete(int idx, int count) {
        if (idx == 0) {
            Node cur = head;
            for (int i = 0; i < count; i++) {
                cur = cur.next;
            }
            head = cur;
        } else {
            Node cur = head;
            for (int i = 1; i < idx; i++) {
                cur = cur.next;
            }

            Node next = cur;
            for (int i = 0; i < count; i++) {
                next = next.next;
            }
            cur.next = next.next;
            if (cur.next == null) {
                tail = cur;
            }
        }
    }

    void add(int data){
        Node cur = tail;
        Node newNode = newNode(data);
        cur.next = newNode;
        tail = newNode;
    }

    ArrayList<Integer> getPass(){
        ArrayList<Integer> list = new ArrayList<>();
        Node cur = head;
        for (int i = 0; i < 10; i++) {
            list.add(cur.data);
            cur = cur.next;
        }
        return list;
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

            LinkedList list = new LinkedList();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            list.insert(0, arr.length, arr);

            int cmd = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < cmd; i++) {
                String op = st.nextToken();
                if ("I".equals(op)) {
                    int idx = Integer.parseInt(st.nextToken());
                    int cnt = Integer.parseInt(st.nextToken());
                    arr = new int[cnt];
                    for (int j = 0; j < cnt; j++) {
                        arr[j] = Integer.parseInt(st.nextToken());
                    }
                    list.insert(idx, cnt, arr);
                } else if ("A".equals(op)) {
                    int cnt = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < cnt; j++) {
                        list.add(Integer.parseInt(st.nextToken()));
                    }
                } else {
                    int idx = Integer.parseInt(st.nextToken());
                    int cnt = Integer.parseInt(st.nextToken());
                    list.delete(idx, cnt);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int code : list.getPass()) {
                sb.append(code + " ");
            }
            System.out.printf("#%d %s\n", test_case, sb.toString());
        }
    }
}