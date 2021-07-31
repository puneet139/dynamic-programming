package examples.week1;

import java.util.Scanner;

public class MinimumSumPartition {

    public static int minDifference(int arr[], int n)
    {
        // Your code goes here
        int sum =0;

        for(int i=0;i<n;i++){
            sum += arr[i];
        }

        boolean dp[][] = new boolean[n+1][sum+1];

        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }

        for(int j=1;j<=sum;j++){
            dp[0][j] = false;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int diff = Integer.MAX_VALUE;

        for(int k=sum/2;k>=0;k--){
            if(dp[n][k]){
                diff = sum - (2*k);
                break;
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(minDifference(arr,n));
    }
}
