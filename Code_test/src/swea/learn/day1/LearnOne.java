package swea.learn.day1;

// 수학적 귀납법
// P(1)이 참이다. -> sum(1)은 1이다.
// P(x) -> P(x+1)이 참이다. 이것도 sum(x-1)이 1~x-1까지의 합을 나타낸다면, sum(x)도 1~x를 나타낸다.

// 재귀에서는 sum(x-1)을 블랙박스로 봐야 이해의 도움을 준다.
public class LearnOne {
    public static int sum(int x){
        if (x <= 0) {
            return 0;
        }
        return x + sum(x - 1);
    }
    public static void main(String[] args) {
        System.out.println(sum(10));
    }
}
