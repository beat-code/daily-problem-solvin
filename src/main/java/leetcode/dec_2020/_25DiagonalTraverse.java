package leetcode.dec_2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _25DiagonalTraverse {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4},{4,5,6,7},{7,8,9,10}, {7,8,9,10}};
        int[][] matr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        new _25DiagonalTraverse().findDiagonalsSquareMatrix(mat);
        new _25DiagonalTraverse().findDiagonalsRectMatrix(matr);
    }

    /*1 2  3  4
      5 6  7  8
      9 10 11 12

      1  2  3
      4  5  6
      7  8  9
      10 11 12*/
    public int[] findDiagonalOrder(int[][] matrix) {

        List<List<Integer>> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rev = true;
        for(int i=0;i < n; i++){
            int k=0;
            int l=i;
            List<Integer> nums = new ArrayList<>();
            while(k < m && l >= 0){
                nums.add(matrix[k][l]);
                l--;
                k++;
            }
            if(rev) {
                Collections.reverse(nums);
            }
            rev = !rev;
            ans.add(nums);
        }
        for(int i=1;i < m; i++){
            int k=i;
            int l=n-1;
            List<Integer> nums = new ArrayList<>();
            while(k < m && l >= 0){
                nums.add(matrix[k][l]);
                l--;
                k++;
            }
            if(rev) {
                Collections.reverse(nums);
            }
            rev = !rev;
            ans.add(nums);
        }
        int[] res = new int[m*n];
        int i=0;
        for(List<Integer> ls : ans){
            for(int num : ls){
                res[i++] = num;
            }
        }
        return res;
    }

    /**
     * 1 2 3
     * 4 5 6
     * 7 8 9
     *
     * 1 2 3 4
     * 4 5 6 7
     * 7 8 9 10
     * 7 8 9 10
     */
    public List<Integer> findDiagonalsSquareMatrix(int[][] matrix){
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        for(int i=0;i < n; i++){
            int j=0;
            int k=i;
            while(k>=0 && j<=i){
                ans.add(matrix[j][k]);
                k--;
                j++;
            }
        }
        for(int i=1; i<n; i++){
            int j=i;
            int k=n-1;
            while(k>=0 && j<=n-1){
                ans.add(matrix[j][k]);
                k--;
                j++;
            }
        }
        System.out.println(ans);
        return ans;
    }

    /**
     * 1  2  3  4
     * 5  6  7  8
     * 9  10 11 12
     */
    public List<List<Integer>> findDiagonalsRectMatrix(int[][] matrix){
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i < n; i++){
            int k=0;
            int l=i;
            while(k < m && l >= 0){
                ans.add(matrix[k][l]);
                l--;
                k++;
            }
        }
        for(int i=1;i < m; i++){
            int k=i;
            int l=n-1;
            while(k < m && l >= 0){
                ans.add(matrix[k][l]);
                l--;
                k++;
            }
        }
        /*for(int i=0,j=0;i < n; i++,j++){
            int k=0;
            int l=i;
            while(l>=0 && k<=j){
                ans.add(matrix[k][l]);
                l--;
                k++;
            }
        }*/

        System.out.println(ans);
        return new ArrayList<>();
    }
}
