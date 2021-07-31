package examples.week1;

import java.util.Scanner;

public class SubsetSumProblem {

    static boolean dp[][];

    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        dp = new boolean[N+1][sum+1];
        for(int i=0;i<=N;i++){
            dp[i][0] = true;
        }

        for(int j=1;j<=sum;j++){
            dp[0][j]=false;
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][sum];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        if(isSubsetSum(n,arr,sum)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
