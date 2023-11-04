package swea.d3.n8888;

import java.io.*;
import java.util.StringTokenizer;

public class OtherSolution2 {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static Info[] InformationOfScore;

    public static void main(String[] args) throws IOException {
        StringBuilder builder = new StringBuilder();
        int testCase = Integer.parseInt(reader.readLine());

        for (int j = 1; j <= testCase; j++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            int n = Integer.parseInt(tokenizer.nextToken());
            int t = Integer.parseInt(tokenizer.nextToken());
            int p = Integer.parseInt(tokenizer.nextToken());

            boolean[][] markings = getAnswer(n, t);

            int[] scoreOfProblems = computeTheScore(markings, n, t);

            computeTheScoreOfStudents(scoreOfProblems, markings, n, t);

            int[] result = computeTheFinalScoreAndGrade(n, p);

            builder.append("#" + j + " " + result[0] + " " + result[1] + "\n");
        }

        writer.write(builder.toString());
        writer.flush();
    }

    private static boolean[][] getAnswer(int n, int t) throws IOException {
        boolean[][] markings = new boolean[n][t];
        InformationOfScore = new Info[n];

        for (int row = 0; row < n; row++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            int NofCorrect = 0;

            for (int col = 0; col < t; col++) {
                if (Integer.parseInt(tokenizer.nextToken()) == 1) {
                    markings[row][col] = true;
                    NofCorrect++;
                }
            }

            InformationOfScore[row] = new Info(row + 1, NofCorrect);
        }

        return markings;
    }

    private static int[] computeTheScore(boolean[][] answer, int n, int t) {
        int[] scoreOfProblems = new int[t];

        for (int col = 0; col < t; col++) {
            int score = 0;

            for (int row = 0; row < n; row++) {
                if (!answer[row][col]) {
                    score++;
                }
            }

            scoreOfProblems[col] = score;
        }

        return scoreOfProblems;
    }

    private static void computeTheScoreOfStudents(int[] scoreOfProblems, boolean[][] answer, int n,
        int t) {
        for (int row = 0; row < n; row++) {
            int score = 0;

            for (int col = 0; col < t; col++) {
                if (answer[row][col]) {
                    score += scoreOfProblems[col];
                }
            }

            InformationOfScore[row].setScore(score);
        }
    }

    private static int[] computeTheFinalScoreAndGrade(int n, int p) {
        int standardNofCorrect = InformationOfScore[p - 1].getNofCorrect();
        int standardScore = InformationOfScore[p - 1].getScore();

        int finalGreade = 1;
        for (int j = 0; j < n; j++) {
            if (j == p - 1) {
                continue;
            }

            if (InformationOfScore[j].getScore() > standardScore) {
                finalGreade++;
            } else if (InformationOfScore[j].getScore() == standardScore &&
                InformationOfScore[j].getNofCorrect() > standardNofCorrect) {
                finalGreade++;
            } else if (InformationOfScore[j].getScore() == standardScore &&
                InformationOfScore[j].getNofCorrect() == standardNofCorrect &&
                j < p - 1) {
                finalGreade++;
            }
        }

        int[] returnData = new int[2];
        returnData[0] = standardScore;
        returnData[1] = finalGreade;

        return returnData;
    }

    private static class Info {

        private int indexOfStudent;
        private int NofCorrect;
        private int score;

        public Info(int indexOfStudent, int NofCorrect) {
            this.indexOfStudent = indexOfStudent;
            this.NofCorrect = NofCorrect;
        }

        public int getNofCorrect() {
            return NofCorrect;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}
