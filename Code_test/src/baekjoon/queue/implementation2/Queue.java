package baekjoon.queue.implementation2;

class Queue {
    public static final int MAX_CAPACITY = 64;
    int size;
    int[] queue;
    int front;
    int rear;

    Queue() {
        size = front = rear = 0;
        queue = new int[MAX_CAPACITY];
    }

    Queue(int capacity) {
        size = front = rear = 0;
        queue = new int[capacity];
    }

    public void resize(){
        int arrayCapacity = queue.length;

        int[] tmp = new int[queue.length * 2];

        for(int i=1, j = front+1;i<=size;i++, j++){ // 주의 i <= size로 해야함(해당 실수로 18258번 틀림)
            tmp[i] = queue[j % arrayCapacity];
        }
        queue = null;
        queue = tmp;
        this.front = 0;
        this.rear = size;
    }

    public void push(int data){
        if((rear+1) % queue.length == front) resize();
        rear = (rear+1) % queue.length;
        queue[rear] = data;
        size++;
    }

    public int pop(){
        if (size == 0) {
            return -1;
        }
        front = (front+1) % queue.length;
        int tmp = queue[front];
        queue[front] = 0;
        size --;
        return tmp;
    }

    public int size(){
        return size;
    }

    public int empty(){
        if(size == 0) return 1;
        return 0;
    }

    public int front(){
        if (size == 0) {
            return -1;
        }
        return queue[(front + 1) % queue.length];
    }

    public int back(){
        if(size == 0){
            return -1;
        }
        return queue[rear];
    }

}
