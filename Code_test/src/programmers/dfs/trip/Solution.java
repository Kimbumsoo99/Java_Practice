package programmers.dfs.trip;
import java.util.*;

public class Solution {
    boolean[] visited;
    ArrayList<String> allRoute;

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int cnt = 0;
        visited = new boolean[tickets.length];
        allRoute = new ArrayList<>();

        dfs("ICN", "ICN", tickets, cnt);

        Collections.sort(allRoute);
        answer = allRoute.get(0).split(" ");


        return answer;
    }

    public void dfs(String start, String route, String[][] tickets, int cnt){
        if(cnt == tickets.length){
            System.out.println(route);
            allRoute.add(route);
            return;
        }

        for(int i=0; i<tickets.length; i++){
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] answer = s.solution(new String[][]{{"ICN", "JFK"},{"HND", "IAD"}, {"JFK", "HND"}});
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
        System.out.println();

        String[] answer2 = s.solution(
            new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"},
                {"ATL", "SFO"}});
        for (int i = 0; i < answer2.length; i++) {
            System.out.println(answer2[i]);
        }
    }
}