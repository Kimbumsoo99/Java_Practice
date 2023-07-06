package sort.quick;

public class Solution {
    public static void sort(int[] arr, int left, int right){
        int pl = left;
        int pr = right;
        int x = arr[(pl+pr)/2];

        do{
            while(arr[pl] < x) pl++;
            while(arr[pr] > x) pr--;
            if(pl <= pr){
                int temp = arr[pl];
                arr[pl] = arr[pr];
                arr[pr] = temp;
                pl++;
                pr--;
            }
        }while(pl <= pr);

        if(left < pr) sort(arr, left, pr);
        if(right > pl) sort(arr, pl, right);
    }
    public static void main(String args[]){
        int[] arr = {23,41,3,64,37,5,412,346,75,45,234,5,64,7,68,98,80,97,78,65,7,85,35,23};
        sort(arr, 0, arr.length - 1);
        System.out.print("[");
        for(int i = 0;i<arr.length - 1;i++){
            System.out.print(arr[i]+", ");
        }
        System.out.println(arr[arr.length - 1] + "]");
    }
}
