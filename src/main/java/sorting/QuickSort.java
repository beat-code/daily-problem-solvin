package sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {12,3,1,13,0,4,11,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        sort(arr, 0, arr.length-1);
    }

    public static void sort(int[] arr, int l, int r){
        if(l < r){
            int pi = partition(arr, l, r);
            sort(arr, l, pi-1);
            sort(arr, pi+1, r);
        }
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];

        int pi = l-1;

        for(int j=l; j<r; j++){
            if(arr[j] < pivot){
                pi++;
                swap(arr, j, pi);
            }
        }
        swap(arr, pi+1, r);

        return pi+1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
