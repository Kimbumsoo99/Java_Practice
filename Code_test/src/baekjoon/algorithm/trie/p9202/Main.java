package baekjoon.algorithm.trie.p9202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    static int N, W;
    static int[] dy = new int[]{-1, -1, -1, 0, 0, 1, 1, 1}, dx = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    static char[][][] Graph;
    static boolean[][][] visit;
    static Trie trie;
    static Answer[] answers;
    static StringBuilder temp =  new StringBuilder();
    static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        W = Integer.parseInt(br.readLine());
        words = new String[W];
        for (int i = 0; i < W; i++) {
            String s = br.readLine();
            words[i] = s;
        }

        br.readLine();

        N = Integer.parseInt(br.readLine());
        answers = new Answer[N];
        Graph = new char[N][4][4];
        visit = new boolean[N][4][4];
        for (int i = 0; i < N; i++) {
            answers[i] = new Answer();
            for (int j = 0; j < 4; j++) {
                char[] words = br.readLine().toCharArray();
                Graph[i][j] = Arrays.copyOf(words, words.length);
            }
            br.readLine();
        }

        for (int i = 0; i < N; i++) {
            trie = new Trie();
            init();
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    visit[i][j][k] = true;
                    if (trie.root.children.containsKey(Graph[i][j][k])) {
                        temp.append(Graph[i][j][k]);
                        dfs(i, j, k, trie.root.children.get(Graph[i][j][k]), 0);
                        temp.delete(0, temp.length());
                    }
                    visit[i][j][k] = false;
                }
            }
            if (answers[i].count == 0) {
                sb.append(String.format("%d %d\n", answers[i].sumScore, answers[i].count));
            } else {
                sb.append(String.format("%d %s %d\n", answers[i].sumScore, answers[i].maxString, answers[i].count));
            }
        }
        System.out.println(sb);
    }

    private static void dfs(int i, int y, int x, Node pre, int idx) {
        if (pre.isEnd) {
            answers[i].count++;
            answers[i].strDiff(temp.toString());
            answers[i].sumScore += pre.score;
            trie.delete(temp.toString());
        }
        // A
        for (int j = 0; j < 8; j++) {
            int nextY = y + dy[j];
            int nextX = x + dx[j];
            if (isMap(nextY, nextX) && !visit[i][nextY][nextX]) {
                // C -> A가 끝이아니고, A하위 C로 가는 정답이 있으면 고
                if (!pre.isEnd && pre.children.containsKey(Graph[i][nextY][nextX])) {
                    visit[i][y][x] = true;
                    temp.append(Graph[i][nextY][nextX]);
                    dfs(i, nextY, nextX, pre.children.get(Graph[i][nextY][nextX]), idx + 1);
                    temp.deleteCharAt(temp.length() - 1);
                    visit[i][y][x] = false;
                }
            }
        }
    }

    private static boolean isMap(int y, int x){
        return y >= 0 && y < 4 && x >= 0 && x < 4;
    }

    private static void init() {
        for (String word : words) {
            trie.insert(word);
        }
    }

    static class Answer {
        int sumScore;
        String maxString;
        int count;

        public void strDiff(String vvs) {
            if (maxString == null) {
                maxString = vvs;
                return;
            }

            if(maxString.length() < vvs.length()){
                maxString = vvs;
                return;
            } else if(maxString.length() > vvs.length()){
                return;
            }

            maxString = maxString.compareTo(vvs) < 0 ? maxString : vvs;
        }
    }

    static class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        public void delete(String str) {
//            System.out.println("delete : " + str);
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
            cur.score = getScore(word);
        }

        private int getScore(String word) {
            int length = word.length();
            switch (length) {
                case 1:
                case 2:
                    return 0;
                case 3:
                case 4:
                    return 1;
                case 5:
                    return 2;
                case 6:
                    return 3;
                case 7:
                    return 5;
                default:
                    return 11;
            }
        }
    }

    static class Node {
        HashMap<Character, Node> children;
        boolean isEnd;
        int score;

        Node() {
            this.children = new HashMap<>();
            this.isEnd = false;
            this.score = 0;
        }

        @Override
        public String toString() {
            return "" + children;
        }
    }
}