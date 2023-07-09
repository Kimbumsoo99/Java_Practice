package queue.array_queue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {
    private static final int DEFAULT_CAPACITY = 64;

    private Object[] array;
    private int size;

    private int front;
    private int rear;

    public ArrayQueue() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    public ArrayQueue(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    /**
     * Queue 크기를 다시 지정하는 메서드
     *
     * @param newCapacity
     */
    private void resize(int newCapacity){
        int arrayCapacity = array.length;
        Object[] newArr = new Object[newCapacity];

        for(int i=1, j=front+1;i<=size;i++, j++){
            newArr[i] = array[j % arrayCapacity];
        }
        this.array = null;
        this.array = newArr;

        front = 0;
        rear = size;
    }

    @Override
    public boolean offer(E e) {
        if((rear + 1) % array.length == front){
            resize(array.length * 2);
        }
        rear = (rear + 1) % array.length;

        array[rear] = e;
        size++;

        return true;
    }

    @Override
    public E poll() {
        if (size == 0) {
            return null;
        }

        front = (front + 1) % array.length;

        E item = (E) array[front];

        array[front] = null;
        size--;

        // 안해도 되는 코드.
        // 배열에 1/4가 안찼는데, 용적 크기보다 배열이 큰 경우
        if (array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }

        return item;
    }

    public E remove(){
        E item = poll();
        if (item == null) {
            throw new NoSuchElementException();
        }

        return item;
    }

    @Override
    public E peek() {
        if(size == 0){
            return null;
        }

        E item = (E) array[(front + 1) % array.length];
        return item;
    }

    public E element(){
        E item = peek();
        if (item == null) {
            throw new NoSuchElementException();
        }
        return item;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(Object item){
        int start = (front + 1) % array.length;

        for (int i = 0, idx = start; i < size; i++, idx = (idx + 1) % array.length) {
            if (array[idx].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public void clear(){
        for(int i=0;i<array.length;i++){
            array[i] = null;
        }

        front = rear = size = 0;
    }
}
