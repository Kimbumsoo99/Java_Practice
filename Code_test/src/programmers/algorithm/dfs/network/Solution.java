package programmers.algorithm.dfs.network;
class Solution {
    static int N;
    static boolean[] visit;
    static int count = 0;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.N = n;
        visit = new boolean[N];

        // answer += dfs(computers, 0);
        for(int i=0;i<N;i++){
            // System.out.println("answer" + answer + " " + i);
            if(!visit[i]) {
                answer += dfs(computers, i);
            }
        }
        return answer;
    }
    static int dfs(int[][] computers, int current){
        visit[current] = true;
        // System.out.println("익명 " + current);
        for(int i=0;i<N;i++){
            // System.out.println("visit " + visit[i] + " " + i);
            if(!visit[i] && current != i && computers[current][i] == 1){
                dfs(computers, i);
            }
        }
        return 1;
    }
}