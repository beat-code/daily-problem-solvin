package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {12,3,1,13,0,4,11,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        for(int i=1; i<arr.length; i++){
            int j=i-1;
            int num = arr[i];
            while(j >= 0 && arr[j] > num){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = num;
        }
    }
}
