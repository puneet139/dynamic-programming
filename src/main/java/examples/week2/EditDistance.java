package examples.week2;

import java.util.Scanner;

public class EditDistance {

    public static int editDistance(String s, String t) {
        // Code here
        if(s.equals(t)){
            return 0;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int m = sArray.length;
        int n = tArray.length;

        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0] = i;
        }

        for(int j=1;j<=n;j++){
            dp[0][j] = j;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(sArray[i-1]==tArray[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]);
                }

            }
        }

        return dp[m][n];
    }

    static int min(int a,int b, int c){
        if(a<b && a<c){
            return a;
        }else if(b<a && b<c){
            return b;
        }else{
            return c;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String firstString = sc.next();
        String secondString = sc.next();
        System.out.println(editDistance(firstString,secondString));
    }
}
