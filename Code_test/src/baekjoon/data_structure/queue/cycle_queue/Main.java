package baekjoon.data_structure.queue.cycle_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> dq = new LinkedList<>();
        for(int i=1;i<=N;i++){
            dq.offer(i);
        }
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        int length = N;
        int mid = N % 2 == 0 ? N / 2 - 1 : N / 2;
        int count = 0;
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            int targetIndex = dq.indexOf(num);
            mid = dq.size() % 2 == 0 ? dq.size() / 2 - 1 : dq.size() / 2;

            if (mid < dq.indexOf(num)) {
//                System.out.println("->" + (dq.size() - targetIndex));
                for(int k=0;k<dq.size()-targetIndex;k++){
                    int tmp = dq.removeLast();
                    dq.offerFirst(tmp);
//                    System.out.print(tmp);
                    count++;
                }
//                System.out.println();
            }else{
                for (int j = 0; j < targetIndex; j++) {
                    int tmp = dq.remove();
                    dq.offerLast(tmp);
                    count++;
                }
            }
            dq.remove();

//            System.out.println();
        }
        System.out.println(count);
    }

}
