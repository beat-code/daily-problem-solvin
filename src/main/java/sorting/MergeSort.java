package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {12,3,1,13,0,4,11,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        sort(arr, 0, arr.length-1);
    }

    private static void sort(int[] arr, int l, int r){
        if(l<r){
            int mid = l+(r-l)/2;
            sort(arr, l,mid);
            sort(arr, mid+1, r);
            merge(arr, l, mid, mid+1, r);
        }
    }

    private static void merge(int[] arr, int l1, int r1, int l2, int r2) {
        int[] temp = new int[r1-l1+1 + r2-l2+1];
        int i=l1, j=l2;
        int k=0;
        while(i<=r1 && j<=r2){
            if(arr[i] > arr[j]){
                temp[k++]=arr[j++];
            }else{
                temp[k++]=arr[i++];
            }
        }
        while(i<=r1){
            temp[k++] = arr[i++];
        }
        while(j<=r2){
            temp[k++] = arr[j++];
        }
        k=0;
        for(i=l1; i<=r2;i++){
            arr[i]=temp[k++];
        }
    }
}
