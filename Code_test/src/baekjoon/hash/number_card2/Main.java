package baekjoon.hash.number_card2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    public static int upperBound(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;

        while (lo < hi){

            int mid = (lo + hi) / 2; // 중간위치를 구한다.

            // key값이 중간 위치의 값보다 작을 경우
            if (key < arr[mid]) hi = mid;
            // 중복원소의 경우 else에서 처리된다.
            else lo = mid + 1;
        }
        return lo;
    }
    public static int lowerBound(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;

        while (lo < hi){
            int mid = (lo + hi) / 2; // 중간 위치

            /*
             *  key 값이 중간 위치의 값보다 작거나 같을 경우
             *
             *  (중복 원소에 대해 왼쪽으로 탐색하도록 상계를 내린다.)
             */
            if (key <= arr[mid]) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    public static StringBuilder solutionBinarySearch(int N, int[] binarySearch, int M, Iterator<Integer> binaryIt){
        Arrays.sort(binarySearch); // 이분 탐색을 위해서는 반드시 정렬

        StringBuilder answer = new StringBuilder();
        for(int i=0;i<M;i++){
            int key = binaryIt.next();

            answer.append(upperBound(binarySearch, key) - lowerBound(binarySearch, key)).append(' ');
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
//        HashMap<Integer, Integer> map = new HashMap<>();    // card, count

        int[] binarySearch = new int[N];

        for(int i=0;i<N;i++){
            int tmp = Integer.parseInt(st.nextToken());
//            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            binarySearch[i] = tmp;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> binarySearchM = new ArrayList<>();
        for(int i=0;i<M;i++){
            int tmp = Integer.parseInt(st.nextToken());
            binarySearchM.add(tmp);
//            if (map.containsKey(tmp)) {
//                sb.append(map.get(tmp)).append(" ");
//            }else{
//                sb.append(0).append(" ");
//            }
        }
        Iterator<Integer> binaryIt = binarySearchM.iterator();

        System.out.println(solutionBinarySearch(N, binarySearch, M, binaryIt));
//        System.out.println(sb.toString());
    }

}
