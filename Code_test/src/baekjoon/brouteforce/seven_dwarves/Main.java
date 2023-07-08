package baekjoon.brouteforce.seven_dwarves;
import java.util.*;
public class Main {
    public static ArrayList find(ArrayList<Integer> list, int sum){
        for(int i = 0;i<8;i++){
            for(int j = i+1; j<9;j++){
//                System.out.println(list.get(i) + " " + list.get(j));
                if(sum-list.get(i)-list.get(j) == 100){
                    list.remove(j);
                    list.remove(i);
                    return list;
                }
            }
        }
        return null;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i =0;i<9;i++){
            list.add(Integer.valueOf(sc.nextInt()));
            sum += list.get(i);
        }
//        System.out.println(list.toString());

        list = find(list, sum);

        Collections.sort(list);
//        System.out.println(list.toString());
        for(int i =0;i<7;i++){
            System.out.println(list.get(i));
        }
    }
}
