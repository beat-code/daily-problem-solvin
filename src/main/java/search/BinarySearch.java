package search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,7,10,12};
        System.out.println(search(arr, 12));
    }
    public static int search(int[] arr, int key){
        int l=0;
        int r=arr.length-1;

        while (l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid] == key) return mid;
            else if(arr[mid] > key) r=mid-1;
            else l=mid+1;
        }
        return -1;
    }

    public static int searchWithDuplicates(int[] arr, int key){
        int l=0;
        int r=arr.length-1;

        while (l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid] == key) return mid;
            else if(arr[mid] > key) r=mid-1;
            else l=mid+1;
        }
        return -1;
    }
}
