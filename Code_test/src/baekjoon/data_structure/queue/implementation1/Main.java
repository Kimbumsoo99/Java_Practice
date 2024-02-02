package baekjoon.data_structure.queue.implementation1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Queue {
        public static final int DEFALUT_CAPACITY = 10001;
        int[] queue;
        int size;
        int front;
        int tail;

        Queue(int size) {
            queue = new int[size];
            this.size = front = tail = 0;
        }
        Queue() {
            queue = new int[DEFALUT_CAPACITY];
            size = front = tail = 0;
        }

        void resize(){
            int length = queue.length;
            int[] newArr = new int[length * 2];
            for (int i = 1, j = front + 1; i < size+1; i++, j++) {
                newArr[i] = queue[j % length];
            }
            queue = null;
            queue = newArr;
            front = 0;
            tail = size;
        }

        void push(int data){
            if(front == (tail + 1) % queue.length){
                resize();
            }
            tail = (tail + 1) % queue.length;
            queue[tail] = data;
            size++;
        }

        int pop(){
            if(size == 0) return -1;
            front = (front + 1) % queue.length;
            int tmp = queue[front];
            queue[front] = 0;
            size--;
            return tmp;
        }
        int size(){
            return size;
        }
        int empty(){
            if (size == 0) {
                return 1;
            }
            return 0;
        }
        int front(){
            if(size == 0) return -1;
            return queue[front + 1];
        }
        int back(){
            if(size == 0) return -1;
            return queue[tail];
        }
    }

    public static void main(String[] args) throws IOException {
        Queue q = new Queue();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                int data = Integer.parseInt(st.nextToken());
                q.push(data);
            } else if (command.equals("pop")) {
                sb.append(q.pop()).append("\n");
            } else if (command.equals("size")) {
                sb.append(q.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(q.empty()).append("\n");
            } else if (command.equals("front")) {
                sb.append(q.front()).append("\n");
            } else if (command.equals("back")) {
                sb.append(q.back()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
