import java.io.*;
import java.util.*;
 
public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
           return o2 - o1;
        });
        
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
 
            if(a == 0){
                if(pq.isEmpty()) sb.append(-1).append("\n");
                else sb.append(pq.poll()).append("\n");
            }
            else{
                for (int j = 0; j < a; j++) {
                    pq.offer(Integer.parseInt(st.nextToken()));
                }
            }
        }
 
        System.out.print(sb);
    }
}
