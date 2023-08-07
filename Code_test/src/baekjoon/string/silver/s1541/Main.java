package baekjoon.string.silver.s1541;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 1514번, 잃어버린 괄호, 실버 II

public class Main {
    static int answer = 0;
    static int[] dx = {-1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String calc = br.readLine();

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> op = new ArrayList<>();
        String num = "";
        for (char n : calc.toCharArray()) {
            // 만약 문제가 -3+1 이런 경우라면? 첫 문자 처리는 어떻게 하지?
            if (Character.isDigit(n)) {
                num += n;
            } else {
                list.add(Integer.parseInt(num));
                num = String.valueOf(n);
            }
        }
        list.add(Integer.parseInt(num));
        dfs(list, 0);
        System.out.println(answer);
    }

    static void draw(ArrayList<Integer> list){
        for(Integer n : list){
            System.out.print(n + " ");
        }
        System.out.println();
    }

    static void dfs(ArrayList<Integer> list, int index){
//        draw(list);
        int nextX = index + 1;
        int nextnextX = index + 2;
        if (nextnextX < list.size()) {
//            System.out.println(list.size() + " " + list.get(nextX) + " " + list.get(nextnextX));
            int N = list.get(nextX);
            int M = list.get(nextnextX);
            if (N < 0 && M > 0) {
                list.remove(nextX);
                list.set(nextX, N - M);
            }else{
                int tmp = list.get(0) + N;
                list.remove(0);
                list.set(0, tmp);
//                draw(list);
            }
            dfs(list, 0);
        }else if(nextX < list.size()){
            answer = list.get(0) + list.get(nextX);
        }
        else{
            answer = list.get(0);
        }
    }
}



