package baekjoon.algorithm.trie.p5670;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                int N = Integer.parseInt(br.readLine());
                Trie trie = new Trie(N);
                String[] inputs = new String[N];
                for (int i = 0; i < N; i++) {
                    inputs[i] = br.readLine();
                    char[] words = inputs[i].toCharArray();
                    trie.insert(words);
                }

                double ans = 0;
                for (int i = 0; i < N; i++) {
                    String tmp = inputs[i];
                    int search = trie.search(tmp.toCharArray());
                    ans += search;
                }
                ans /= N;
                sb.append(String.format("%.2f\n", ans));
            } catch (Exception e) {
                System.out.println(sb);
                return;
            }
        }
    }

    static class Node{
        HashMap<Character, Node> child;
        boolean end;

        Node(){
            this.child = new HashMap<>();
            this.end = false;
        }
    }

    static class Trie{
        Node root;
        int N;
        public Trie(int N){
            root = new Node();
            this.N = N;
        }

        public void insert(char[] words){
            Node cur = this.root;
            for (char word : words) {
                if (!cur.child.containsKey(word)) {
                    cur.child.put(word, new Node());
                }
                cur = cur.child.get(word);
            }
            cur.end = true;
        }
        public int search(char[] words){
            Node cur = this.root.child.get(words[0]);
            Node pre = cur;
            int ans = 1;
            for (int i = 1; i < words.length; i++) {
                char word = words[i];
                cur = cur.child.get(word);
                if (pre.end || pre.child.size() > 1) {
                    ans++;
                }
                pre = cur;
            }
            return ans;
        }
    }
}