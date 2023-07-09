package queue.linked_queue;

import java.util.NoSuchElementException;
import queue.array_queue.Queue;

public class LinkedQueue<E> implements Queue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean offer(E item) {
        Node<E> newNode = new Node<E>(item);

        if(size == 0){
            head = newNode;
        }
        else{
            tail.next = newNode;
        }

        tail = newNode;
        size++;

        return true;
    }

    @Override
    public E poll() {
        if(size == 0){
            return null;
        }

        E element = head.data;

        Node<E> nextNode = head.next;
        head.data = null;
        head.next = null;

        head = nextNode;
        size--;

        return element;
    }

    public E remove(){
        E e = poll();
        if (e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }

    @Override
    public E peek() {
        if(size == 0){
            return null;
        }
        return head.data;
    }

    public E element(){
        E e = peek();
        if (e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object value) {

        for(Node<E> x = head; x != null; x = x.next) {
            if(value.equals(x.data)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {

        for(Node<E> x = head; x != null; ) {

            Node<E> next = x.next;
            x.data = null;
            x.next = null;
            x = next;
        }
        size = 0;
        head = tail = null;

    }

}
