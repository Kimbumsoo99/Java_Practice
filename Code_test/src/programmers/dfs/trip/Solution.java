package programmers.dfs.trip;
import java.util.*;

public class Solution {
    static boolean[] visit;
    static ArrayList<String> tripGuide = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visit = new boolean[tickets.length];
        dfs("ICN", "ICN", tickets, 0);


        // for(int i=0;i<tripGuide.size();i++){
        //     System.out.println(tripGuide.get(i));
        // }
        Collections.sort(tripGuide, (o1, o2) -> o1.compareTo(o2));
        answer = tripGuide.get(0).split(" ");

        return answer;
    }

    static void dfs(String current, String route, String[][] tickets, int count){
        // System.out.println(route);
        // 종료 조건
        if(count == tickets.length){
            tripGuide.add(route);
            return;
        }

        // 탐색
        for(int i=0;i<tickets.length;i++){
            if(!visit[i] && tickets[i][0].equals(current)){
                visit[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, count + 1);
                visit[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] answer = s.solution(new String[][]{{"ICN", "JFK"},{"HND", "IAD"}, {"JFK", "HND"}});
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();

        String[] answer2 = s.solution(
            new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"},
                {"ATL", "SFO"}});
        for (int i = 0; i < answer2.length; i++) {
            System.out.print(answer2[i] + " ");
        }
    }
}