package programmers.sort.biggernum;
import java.util.*;

class Solution {
    public static String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (arr[0].equals("0")) return "0";

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < arr.length; i++) answer.append(arr[i]);
        return answer.toString();
    }

    public static void main(String[] args){
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }
}