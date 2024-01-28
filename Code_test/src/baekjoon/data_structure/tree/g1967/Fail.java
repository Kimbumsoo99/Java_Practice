package baekjoon.data_structure.tree.g1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node{
    int data;
    int parentLength;
    ArrayList<Node> childList;
    Node(int data, int parentLength){
        this.data = data;
        this.parentLength = parentLength;
        childList = new ArrayList<>();
    }
}
public class Fail {
    static ArrayList<Node> parentList = new ArrayList<>();
    static int answer = 0;

    static void insertNode(int data, Node node, int child, int lenght){
        if (node.data == data) {
            node.childList.add(new Node(child, lenght));
            return;
        }else{
            for (Node n : node.childList) {
                insertNode(data, n, child, lenght);
            }
        }
    }

    static void order(Node node, int sumLenght) {
        sumLenght += node.parentLength;
        for (Node child : node.childList) {
            order(child, sumLenght);
        }
//        System.out.println(node.data + "번 노드 : " + answer + " " + sumLenght);
        answer = Math.max(answer, sumLenght);
    }

    static void order2(Node node, int sumLength){
        if (node.childList.size() < 2) {
            return;
        }
        for (int i = 0; i < node.childList.size(); i++) {
            for (int j = i + 1; j < node.childList.size(); j++) {
//                System.out.println(node.data + " 노드 지름 / 크기 " + sumLength + " " + i + " " + j);
                int lenA = getLength(node.childList.get(i), node.childList.get(i).parentLength);
                int lenB = getLength(node.childList.get(j), node.childList.get(j).parentLength);
//                System.out.println(node.data + " 노드 지름 " + (lenA + lenB));
                answer = Math.max(answer, lenA + lenB);
            }
        }
    }

    static int order3(Node node){
        int max = 0;
        for (int i = 0; i < node.childList.size(); i++) {
            for (int j = i + 1; j < node.childList.size(); j++) {
                int lenA = order3GetLen(node.childList.get(i), node.childList.get(i).parentLength);
                int lenB = order3GetLen(node.childList.get(j), node.childList.get(j).parentLength);
                max = Math.max(max, lenA + lenB);
            }
        }
        return max;
    }
    static int order3GetLen(Node node, int len) {
        int sum = len;
        int max = 0;
        for (Node child : node.childList) {
            max = Math.max(max, order3GetLen(child, child.parentLength));
        }
//        System.out.println(sum + max + " " + node.data);
        return max + sum;
    }

    static void searchNode(Node root){
        if (root.childList.size() > 1) {
            parentList.add(root);
        }
        for (Node node : root.childList) {
            searchNode(node);
        }
    }
    static int getLength(Node node, int sum) {
//        System.out.println(node.data + " " + sum);
        if (node.childList.size() > 1) {
            order2(node, 0);
        }
        int max = sum;
        for (Node n : node.childList) {
            max = Math.max(max, getLength(n, sum + n.parentLength));
        }
//        System.out.println(node.data + "의 반환 값 : " + max);
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Node root = new Node(1, 0);
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            insertNode(A, root, B, L);
        }
//        order2(root, 0);
        searchNode(root);
        for (Node node : parentList) {
//            System.out.println(node.data + " 시작 " +answer);
            answer = Math.max(answer, order3(node));
        }
        System.out.println(answer);
    }
}
