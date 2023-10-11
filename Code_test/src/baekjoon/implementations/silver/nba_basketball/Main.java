package baekjoon.implementations.silver.nba_basketball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> teamScore = new HashMap<>();
        HashMap<Integer, String> teamTime = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        teamScore.put(1, 0);
        teamScore.put(2, 0);
        teamTime.put(1, "00:00");
        teamTime.put(2, "00:00");
        boolean oneWin = false;
        boolean twoWin = false;
        String lastTime = "00:00";
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            String[] time = st.nextToken().split(":");
            teamScore.put(team, teamScore.get(team) + 1);
            if (teamScore.get(1) > teamScore.get(2)) {
                if (oneWin) {
                    continue;
                }
                oneWin = true;
                twoWin = false;
                lastTime = time[0] + ":" + time[1]; // 1팀이 이기기 시작한 시간
            } else if (teamScore.get(1) < teamScore.get(2)) {
                if (twoWin) {
                    continue;
                }
                twoWin = true;
                oneWin = false;
                lastTime = time[0] + ":" + time[1]; // 2팀이 이기기 시작한 시간
            } else {
                int addTeam = team == 1 ? 2 : 1;
                String originTime = teamTime.get(addTeam); // 이기고 있던 시간 get
//                System.out.println(lastTime + " " + time[0]+":"+time[1] + " " + originTime);
                String diffTime = timeDiff(lastTime, time, originTime); // 현재 시간으로부터 마지막 점수차 시간 get
                teamTime.put(addTeam, diffTime);
                oneWin = false;
                twoWin = false;
            }
        }
        if (oneWin || twoWin) {
            int addTeam = 1;

            if (oneWin) {
                addTeam = 1;
            } else if (twoWin) {
                addTeam = 2;
            }
            String originTime = teamTime.get(addTeam);
            String diffTime = timeDiff(lastTime, "48:00".split(":"), originTime);
            teamTime.put(addTeam, diffTime);
        }

        System.out.println(teamTime.get(1));
        System.out.println(teamTime.get(2));
    }

    private static String timeDiff(String lastTime, String[] time, String originTime) {
        String[] last = lastTime.split(":");
        int MM = Integer.parseInt(time[0]) - Integer.parseInt(last[0]);
        int tS = Integer.parseInt(time[1]);
        int lS = Integer.parseInt(last[1]);
        if (tS < lS) {
            MM--;
            tS += 60;
        }
        int SS = tS - lS;

        String[] origin = originTime.split(":");
        int oM = Integer.parseInt(origin[0]);
        int oS = Integer.parseInt(origin[1]);

        oM += MM;
        if (oS + SS >= 60) {
            oM++;
            oS = (oS + SS) % 60;
        } else {
            oS += SS;
        }

        String convertMM = convert(oM);
        String convertSS = convert(oS);
//        System.out.println(convertMM + " " + convertSS);

        return convertMM + ":" + convertSS;
    }

    private static String convert(int time) {
        if (String.valueOf(time).length() == 1) {
            if (time == 0) {
                return "00";
            } else {
                return "0" + time;
            }
        }
        return String.valueOf(time);
    }

}
