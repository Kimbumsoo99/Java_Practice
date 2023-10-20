package baekjoon.implementations.silver.s4358;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// 생태학, 실버 II, 4358번
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int count = 0;
        ArrayList<String> treeList = new ArrayList<>();
        HashMap<String, Integer> treeMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        while (true) {
            String tmp = br.readLine();
            if (tmp == null || tmp.length() == 0) {
                break;
            }
            if (!treeMap.containsKey(tmp)) {
                treeList.add(tmp);
            }
            treeMap.put(tmp, treeMap.getOrDefault(tmp, 0) + 1);
            count++;
        }
        // 입력이 끝났다는 의미
        Collections.sort(treeList);
        for (String tree : treeList) {
            int treeCount = treeMap.get(tree);
            double per = (treeCount * 100.0) / count;
            sb.append(String.format("%s %.4f\n", tree, per));
        }
        System.out.println(sb);
    }

}
