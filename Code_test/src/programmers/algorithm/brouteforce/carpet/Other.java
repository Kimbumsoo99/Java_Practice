package programmers.algorithm.brouteforce.carpet;

// 수학적 접근 훨씬 빨랐음
public class Other {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int S = brown + yellow;
        for (int width = yellow + 2; width > 0; width--) {
            if(S % width != 0) continue;
            int height = S / width;

            if(brown == width * 2 + (height * 2 - 4)){
                answer[0] = width;
                answer[1] = height;
                break;
            }
        }

        return answer;
    }

}
