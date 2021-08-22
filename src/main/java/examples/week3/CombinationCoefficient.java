package examples.week3;

import java.util.Scanner;

public class CombinationCoefficient {

    static final int MODULO = 1000000007;
    static int nCr(int n, int r)
    {
        // code here
        int[][] dp = new int[n+1][r+1];
        for(int j=1;j<r;j++){
            dp[0][j]=0;
        }

        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=r;j++){
                if(j>i){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = (dp[i-1][j])%MODULO + (dp[i-1][j-1])%MODULO;
                }
            }
        }
        return dp[n][r]%MODULO;

    }

    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(nCr(n,r));
    }
}
