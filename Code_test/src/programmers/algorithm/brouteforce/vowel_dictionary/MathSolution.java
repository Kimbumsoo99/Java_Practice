package programmers.algorithm.brouteforce.vowel_dictionary;

public class MathSolution {
    public int solution(String word) {
        int answer = 0, per = 3905; // per은 AEIOU로 만들 수 있는 낱말의 갯수
        for(String s : word.split("")) answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
        return answer;
    }
}
