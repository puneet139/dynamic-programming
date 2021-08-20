package examples.week3;

import java.util.Scanner;

public class CoinChange {

    public static long count(int S[], int m, int n)
    {
        //code here.
        long[][] dp = new long[m+1][n+1];
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }

        for(int j=1;j<n;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(S[i-1]<=j){
                    dp[i][j] = dp[i-1][j] + dp[i][j-S[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
                //System.out.println(dp[i][j]);
            }
        }
        //int max = Integer.MIN_VALUE;

        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] values = new int[m];
        for(int i=0;i<m;i++){
            values[i] = sc.nextInt();
        }
        System.out.println(count(values,m,n));
    }
}
