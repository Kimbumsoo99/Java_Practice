package baekjoon.brouteforce.remocon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

// 리모컨, 골드 V, 1107번

/**
 * 반례의 엄청 많이 걸려서 계속 수정했지만, 결국 포기
 * 해당 코드의 로직이 완전히 실패한 느낌은 아닌데 결국은 실패했다.
 * 간략하게 요약하자면 코드는 다음과 같다.
 *
 * 3가지를 우선 구한다.
 * 1.찾는 수보다 작은 수 중 가장 큰 수
 * 2.찾는 수보다 큰 수 중 가장 작은 수
 * 3.100채널에서 찾는 수까지 + 또는 - 버튼을 누르는 횟수
 *
 * 이렇게 3가지 경우를 구한다.
 * 1-2번은 여기서 한가지를 더 구해야한다.
 * 1-2번에서 (구한 수의 length() + 찾는 수까지 + 또는 - 버튼을 누르는 횟수)
 * 이렇게 구한 뒤, [1,2,3]번을 비교해서 가장 적게 나온 수가 정답
 */
public class Main {

    static int CH = 100;
    static int find;
    static HashSet<Integer> breakButton = new HashSet<>();
    static ArrayList<Integer> Button = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        find = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        if (M > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                breakButton.add(tmp);
            }
        }

        // 사용 가능한 Button
        for (int i = 0; i < 10; i++) {
            if (!breakButton.contains(i)) {
                Button.add(i);
            }
        }

        int A = closeMinNumTmp(); // 가장 가까운 작은 수
        int B = closeMaxNumTmp(); // 가장 가까운 큰 수
        int C = closePMNum(); // 그냥 +, -가 가까운 경우
//        System.out.println(A + " " + B + " " + C);
        int answer = Math.min(A, Math.min(B, C));
        System.out.println(answer);
    }
    static boolean isMakeNum(int tmp) {
        String makeNum = String.valueOf(tmp);
        for (int i = 0; i < makeNum.length(); i++) {
            if (breakButton.contains(makeNum.charAt(i) - '0')) {
                return false;
            }
        }
        return true;
    }

    private static int closeMaxNumTmp() {
        int tmp = find;
        while (true) {
            if (Math.abs(find - tmp) > closePMNum()) {
                return Integer.MAX_VALUE;
            }
            if (isMakeNum(tmp)) {
                break;
            }
            tmp++;
        }
//        System.out.println("Max: " + tmp);
        return String.valueOf(tmp).length() + Math.abs(find - tmp);
    }

    private static int closeMinNumTmp() {
        int tmp = find;
        while (true) {
            if (tmp < 0) {
                return Integer.MAX_VALUE;
            }
            if (isMakeNum(tmp)) {
                break;
            }
            tmp--;
        }
//        System.out.println("Min: " + tmp);
        return String.valueOf(tmp).length() + Math.abs(find - tmp);
    }

    private static int closeMinNum() {
        boolean keep = true;
        String findNum = String.valueOf(find);
        String makeNum = "";
        for (int i = 0; i < findNum.length(); i++) {
            int f = findNum.charAt(i) - '0';
            for (int j = f; j >= 0; j--) {
                if (breakButton.contains(j)) {
                    continue;
                }
                if (!keep) {
                    makeNum += Button.get(Button.size() - 1);
                    break;
                } else if (j != f) {
                    keep = false;
                }
                makeNum += j;
                break;
            }
            if (makeNum.length() != i + 1 && Button.size() > 0) {
                makeNum = "";

                for (int k = 0; k < findNum.length() - 1; k++) {
                    makeNum += Button.get(Button.size() - 1);
                }
                break;
            }
        }
        if (makeNum.length() == 0) {
            return Integer.MAX_VALUE;
        }
        return String.valueOf(Integer.parseInt(makeNum)).length() + Math.abs(Integer.parseInt(makeNum) - find);
    }

    private static int closeMaxNum() {
        boolean keep = true;
        String findNum = String.valueOf(find);
        String makeNum = "";
        for (int i = 0; i < findNum.length(); i++) {
            int f = findNum.charAt(i) - '0';
            for (int j = f; j < 10; j++) {
                if (breakButton.contains(j)) {
                    continue;
                }
                if (!keep) {
                    makeNum += Button.get(0);
                    break;
                } else if (j != f) {
                    keep = false;
                }
                makeNum += j;
                break;
            }
//            if (makeNum.length() != i + 1 && Button.size() > 0) {
//                makeNum = "";
//                for (int k = 0; k < findNum.length() - 1; k++) {
//                    makeNum += Button.get(Button.size() - 1);
//                }
//                break;
//            }
            if (makeNum.length() != i + 1 && Button.size() > 0) {
                makeNum = "";
                for (int k = 0; k < findNum.length(); k++) {
                    if (k == 0) { // 첫 번째 숫자일 때는, findNum의 첫 번째 숫자보다 크게
                        int tmp = 0;
                        for (int j = (findNum.charAt(0) - '0') + 1; j < 10; j++) {
                            if (!breakButton.contains(j)) {
                                tmp = Button.indexOf(j);
                                break;
                            }
                        }
                        if (tmp == 0) {
                            if (Button.get(0) == 0) {
                                makeNum += Button.get(1) + "" + Button.get(0);
                            } else {
                                makeNum += Button.get(0) + "" + Button.get(0);
                            }
                        } else {
                            makeNum += Button.get(tmp);
                        }
//                        if (Button.size() == 1) {
//                            return Integer.MAX_VALUE;
//                        }
                    } else {
                        makeNum += Button.get(0);
                    }
                }
                break;
            }
        }
        if (makeNum.length() == 0) {
            return Integer.MAX_VALUE;
        }
        return makeNum.length() + Math.abs(Integer.parseInt(makeNum) - find);
    }



    private static int closePMNum() {
        return Math.abs(find - CH);
    }


//    private static int closeMinNumCopy() {
//        boolean getMax = false;
//        boolean getNum = false;
//        String findNum = String.valueOf(find);
//        String makeNum = "";
//        for (int i = 0; i < findNum.length(); i++) {
//            int f = findNum.charAt(i) - '0';
//            if (getMax) { // 가장 큰값을 구했고,
//                for (int j = 9; j >= 0; j--) {
//                    if (!breakButton.contains(j)) {
//                        makeNum += j;
//                        break;
//                    }
//                }
//            } else {
//                for (int j = f; j >= 0; j--) {
//                    if (breakButton.contains(j)) {
//                        continue;
//                    }
//                    if (j == f) {
//                        getMax = true;
//                    }
//                    makeNum += j;
//                    getNum = true;
//                    break;
//                }
//                if (!getNum) { //작은 숫자중에 값을 못찾았다면,
//                    for (int j = f; j < 10; j++) {
//                        if (!breakButton.contains(j)) {
//                            makeNum += j;
//                            getNum = true;
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(makeNum);
//        // 만약 숫자가 안만들어졌다면, return MAX_VALUE;
//
//        return 0;
//    }
}
