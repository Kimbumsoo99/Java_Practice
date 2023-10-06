package baekjoon.implementations.silver.cross_contry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
//            int team = solution();
            HashMap<Integer, Integer> teamCount = new HashMap<>();
            HashMap<Integer, Integer> playTeam = new HashMap<>();
            ArrayList<Integer> list = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int team = Integer.parseInt(st.nextToken());
                list.add(team);
                teamCount.put(team, teamCount.getOrDefault(team, 0) + 1);
                if (!playTeam.containsKey(team) && teamCount.get(team) > 5) {
                    playTeam.put(team, 0);
                }
            }

            HashMap<Integer, Integer> fifthPlayerScore = new HashMap<>();
            ArrayList<Integer> teamScore = new ArrayList<>();
            int idx = 1;
            teamCount.clear();
            for (Integer tmp : list) {
                if (playTeam.containsKey(tmp)) {
                    teamScore.add(tmp);
                    // 5번째 숫자 저장
                    teamCount.put(tmp, teamCount.getOrDefault(tmp, 0) + 1);
                    if (teamCount.get(tmp) == 5) {
                        fifthPlayerScore.put(tmp, idx);
                    }
                    else if (teamCount.get(tmp) < 5) {
                        playTeam.put(tmp, playTeam.get(tmp) + idx);
                    }
                    idx++;
                }
            }
            Iterator<Integer> it = playTeam.keySet().iterator();

            ArrayList<int[]> result = new ArrayList<>();
            while (it.hasNext()) {
                int team = it.next();
                result.add(new int[]{team, playTeam.get(team), fifthPlayerScore.get(team)});
            }

            Collections.sort(result, (o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return o1[2] - o2[2]; // 만약, 팀 점수가 같으면 5번째 등수가 작은 수가 우선
                }
                return o1[1] - o2[1]; // 팀 점수가 작은 게 우선
            });

            sb.append(result.get(0)[0]).append("\n");
        }
        System.out.println(sb);
    }

    private static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> teamCount = new HashMap<>();
        HashMap<Integer, Integer> playTeam = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            int team = Integer.parseInt(st.nextToken());
            list.add(team);
            teamCount.put(team, teamCount.getOrDefault(team, 0) + 1);
            if (!playTeam.containsKey(team) && teamCount.get(team) > 5) {
                playTeam.put(team, 0);
            }
        }

        HashMap<Integer, Integer> fifthPlayerScore = new HashMap<>();
        ArrayList<Integer> teamScore = new ArrayList<>();
        int idx = 1;
        teamCount.clear();
        for (Integer tmp : list) {
            if (playTeam.containsKey(tmp)) {
                teamScore.add(tmp);
                playTeam.put(tmp, playTeam.get(tmp) + idx);
                // 5번째 숫자 저장
                teamCount.put(tmp, teamCount.getOrDefault(tmp, 0) + 1);
                if (teamCount.get(tmp) == 5) {
                    fifthPlayerScore.put(tmp, idx);
                }
                idx++;
            }
        }
        Iterator<Integer> it = playTeam.keySet().iterator();

        ArrayList<int[]> result = new ArrayList<>();
        while (it.hasNext()) {
            int team = it.next();
            result.add(new int[]{team, playTeam.get(team), fifthPlayerScore.get(team)});
        }

        Collections.sort(result, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[2] - o1[2]; // 만약, 팀 점수가 같으면 5번째 등수가 작은 수가 우선
            }
            return o1[1] - o2[1]; // 팀 점수가 작은 게 우선
        });

        return result.get(0)[0];
    }

}
