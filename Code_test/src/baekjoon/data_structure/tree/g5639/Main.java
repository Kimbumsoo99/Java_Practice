package baekjoon.data_structure.tree.g5639;

import java.util.Scanner;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
}
public class Main {
    static void insert(int insertData, Node node){
        if (insertData < node.data) {
            if (node.left == null) {
                node.left = new Node(insertData);
            }else{
                insert(insertData, node.left);
            }
        }else{
            if(node.right == null){
                node. right = new Node(insertData);
            }else{
                insert(insertData, node.right);
            }
        }
    }

    static void postOrder(Node head) {
        if (head == null) {
            return;
        }
        postOrder(head.left);
        postOrder(head.right);
        System.out.println(head.data);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = new Node(Integer.parseInt(sc.nextLine()));

        while(true) {
            try {
                String s=sc.next();
                if(s==null) break;
                insert(Integer.parseInt(s), root);
            }catch (Exception e){
                break;
            }
        }
        postOrder(root);
    }
}
