package baekjoon.queue.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static LinkedList<Integer> funcR(LinkedList<Integer> list){
        LinkedList<Integer> returnList = new LinkedList<>();
//        System.out.print("method");
//        for(int i =0;i<list.size();i++){
//            System.out.print(list.get(i));
//        }
//        System.out.println();
        int size = list.size();
        for(int i=0;i<size;i++){
            int tmp = list.removeLast();
            returnList.offer(tmp);
        }
//        for(int i =0;i<returnList.size();i++){
//            System.out.print(returnList.get(i));
//        }
//        System.out.println();
//        System.out.println("method");
        return returnList;
    }

    public static LinkedList<Integer> funcD(LinkedList<Integer> list){
        if (list.size() == 0) {
            return null;
        }
        list.remove();
        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        boolean err = false;

        for(int test=0;test<T;test++){
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String subS = s.substring(1, s.length() - 1);
            String[] s1 = subS.split(",");
//            for (int i = 0; i < s1.length; i++) {
//                System.out.print(s1[i]);
//            }


            LinkedList<Integer> dq = new LinkedList<>();
            for(int i=0;i<s1.length;i++){
                if(!s1[i].equals(""))
                    dq.offerLast(Integer.valueOf(s1[i]));
            }
//            numArr = numArr.replaceAll("[^0-9]", "");
//            for(int i=0;i<N;i++){
//                try {
//                    dq.offerLast(Character.getNumericValue(numArr.charAt(i)));
//                } catch (NumberFormatException e) {
//                    continue;
//                }
//            }
//            for(int i =0;i<dq.size();i++){
//                System.out.print(dq.get(i));
//            }
//            System.out.println();
            for (char op : oper.toCharArray()) {
//                System.out.println(op);
                if (op == 'R') {
                    dq = funcR(dq);
//                    for(int i =0;i<dq.size();i++){
//                        System.out.print(dq.get(i));
//                    }
//                    System.out.println();
                } else if (op == 'D') {
                    dq = funcD(dq);
                    if (dq == null) {
                        err = true;
                        sb.append("error").append("\n");
                    }
                }
            }
            if (err) {
                err = false;
                continue;
            }
            sb.append("[");
            int size = dq.size();
            if (size > 0) {
                for (int i = 0; i < size - 1; i++) {
                    int tmp = dq.remove();
                    sb.append(tmp).append(",");
                }
                int tmp = dq.remove();
                sb.append(tmp).append("]\n");
            }
            else {
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    }

}
