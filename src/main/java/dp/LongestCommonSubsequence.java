package dp;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(findLCSLengthSimpleRec("naxbxdc", "abdc", 0,0,0));
        System.out.println(findLCSLength("axbxcdxe", "axxcxx"));
        System.out.println(findLCS("axbxcdxe", "cxx"));
    }

    public static int findLCSLengthSimpleRec(String str1, String str2, int i, int j, int curr){
        if(i==str1.length() || j==str2.length()) return 0;
        if(str1.charAt(i)==str2.charAt(j)){
            return 1 + findLCSLengthSimpleRec(str1,str2,i+1,j+1,curr);
        }else{
            return Math.max(findLCSLengthSimpleRec(str1,str2,i+1,j,curr),
                    findLCSLengthSimpleRec(str1,str2,i,j+1,curr));
        }
    }

    public static int findLCSLength(String str1, String str2){
        int m=str1.length();
        int n=str2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }else if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static String findLCS(String str1, String str2){

        int m=str1.length();
        int n=str2.length();
        int[][] dp = new int[m+1][n+1];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }else if(str1.charAt(i)==str2.charAt(j)){
                    dp[i][j]=1+dp[i-1][j-1];
                    //sb.append(str1.charAt(i));
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return sb.toString();
    }
}
