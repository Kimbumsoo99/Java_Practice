package sort.comparator;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args){
        Integer[] arr = {1, 26, 17, 25, 99, 44, 303};
        /*
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        */
        Arrays.sort(arr, (i1, i2) -> i2 - i1);
        System.out.println("Sorted arr[] : " + Arrays.toString(arr));
    }
}
