package baekjoon.algorithm.trie.g5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            flag = false;
            Trie trie = new Trie();
            for (int j = 0; j < N; j++) {
                String tel = br.readLine();
                trie.insert(tel);
            }

            search(trie.root);

            if (!flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void search(Node cur) {
        if(flag) return;

        if (cur.isEnd && !cur.children.isEmpty()) {
            flag = true;
            return;
        }

        for (char c : cur.children.keySet()) {
            search(cur.children.get(c));
        }
    }

    static class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        public void delete(String str) {
            delete(this.root, str, 0);
        }

        public void delete(Node pre, String str, int idx) {
            char c = str.charAt(idx);
            Node cur = pre.children.get(c);
            if (idx == str.length() - 1) {
                cur.isEnd = false;
            } else {
                delete(cur, str, idx + 1);
            }
            if(!cur.isEnd && cur.children.isEmpty()) {
                pre.children.remove(c);
            }
        }

        public void insert(String word) {
            char[] chars = word.toCharArray();
            Node cur = root;
            for (char c : chars) {
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new Node());
                }
                cur = cur.children.get(c);
            }
            cur.isEnd = true;
        }
    }

    static class Node {
        HashMap<Character, Node> children;
        boolean isEnd;

        Node() {
            this.children = new HashMap<>();
            this.isEnd = false;
        }

        @Override
        public String toString() {
            return children.keySet().toString() + " " + isEnd;
        }
    }

}