package baekjoon.queue.implementation1;

class Queue {
    int DEFALUT_CAPACITY = 10000;
    int[] queue;
    int size;
    int front;
    int tail;

    Queue(int size) {
        queue = new int[size];
        size = front = tail = 0;
    }
    Queue() {
        queue = new int[DEFALUT_CAPACITY];
        size = front = tail = 0;
    }

    void resize(){
        int length = queue.length;
        int[] newArr = new int[length * 2];
        front = 0;
        tail = size;
        for (int i = 1; i < size+1; i++) {
            newArr[i] = queue[(front + 1) % length];
        }
        queue = newArr;
    }

    void push(int data){
        if(front == tail){
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
        return queue[front + 1];
    }
    int back(){
        return queue[tail];
    }
}
