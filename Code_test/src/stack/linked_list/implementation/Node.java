package stack.linked_list.implementation;

public class Node {
    private int item;
    private Node node;

    public Node(int item) {
        this.item = item;
        this.node = null;
    }

    protected void linkedNode(Node node){
        this.node = node;
    }
    protected int getData(){
        return this.item;
    }
    protected Node getNextNode(){
        return this.node;
    }
}
