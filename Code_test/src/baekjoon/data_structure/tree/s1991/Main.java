package baekjoon.data_structure.tree.s1991;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        char data;
        Node left;
        Node right;

        Node(char data, char left, char right) {
            this.data = data;
            if (left != '.') {
                this.left = new Node(left, '.', '.');
            }
            if (right != '.') {
                this.right = new Node(right, '.', '.');
            }
        }
    }

    static void insertNode(Node node, char data, char left, char right) {
        if (node == null)
            return;
        else if (node.data == data) {
            if (left != '.') {
                node.left = new Node(left, '.', '.');
            }
            if (right != '.') {
                node.right = new Node(right, '.', '.');
            }
        } else {
            insertNode(node.left, data, left, right);
            insertNode(node.right, data, left, right);
        }
    }

    static void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Node head = new Node('A', '.', '.');
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            insertNode(head, node, left, right);
        }
        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
    }
}

