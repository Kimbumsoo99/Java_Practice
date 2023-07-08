package stack.array_list.implementation;

import java.util.ArrayList;

public class StackImpl {
    int top;
    int size;
    ArrayList<Object> stack;

    public StackImpl() {
        this.top = -1;
        this.size = 0;
        this.stack = new ArrayList<>();
    }

    public void push(Object x){
        this.stack.add(x);
        this.top++;
        this.size++;
    }

    public Object pop(){
        if(this.size < 1) return -1;
        this.size--;
        return this.stack.remove(top--);
    }

    public int size(){
        return this.size;
    }
    public boolean empty(){
        if(this.size < 1) return true;
        return false;
    }
    public Object top(){
        if(!this.empty()) return this.stack.get(top);
        return -1;
    }

}
