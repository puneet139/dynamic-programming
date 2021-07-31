package examples.week1;

import java.util.Scanner;

public class PerfectSumProblem {

    final static int MODULO = 1000000007;

    public static int perfectSum(int arr[],int n, int sum)
    {
        // Your code goes here
        int[][] dp = new int[n+1][sum+1];

        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }

        for(int j=1;j<=sum;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j]%MODULO + dp[i-1][j-arr[i-1]]%MODULO;
                }else{
                    dp[i][j] = dp[i-1][j]%MODULO;
                }
            }
        }
        return dp[n][sum]%MODULO;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        System.out.println(perfectSum(arr,n,sum));
    }
}
