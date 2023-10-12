package swea.d3.n1244;

import java.util.Scanner;
// 성공 코드이지만, 내가 푼 코드가 아닌 다른 사람이 푼 코드라 Fail 로 작성함.
public class Fail {
    static int chance = 0;
    static int max;
    static String[] numbers;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            numbers = sc.next().split("");
            chance = sc.nextInt();
            max = 0;
            if (chance > numbers.length) {
                chance = numbers.length;
            }
            dfs(0, 0);
            System.out.println("#" + test_case + " " + max);
        }
    }

    static void dfs(int start, int depth) {
        if (depth == chance) {
            String result = "";
            for (String tmp : numbers) {
                result += tmp;
            }
            max = Math.max(max, Integer.parseInt(result));
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                String tmp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = tmp;

                dfs(i, depth + 1);

                numbers[j] = numbers[i];
                numbers[i] = tmp;
            }
        }
    }
}
