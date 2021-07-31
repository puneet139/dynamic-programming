package examples.week1;

import java.util.Scanner;

public class EqualSumPartition {

    static boolean dp[][];
    static int equalPartition(int N, int arr[])
    {
        // code here
        int total =0;
        for(int i=0;i<N;i++){
            total += arr[i];
        }
        if((total%2)!=0){
            return 0;
        }else{
            if(checkEqualSubset(N,arr,total/2)){
                return 1;
            }else{
                return 0;
            }
        }
    }

    static boolean checkEqualSubset(int N,int[] arr, int sum){
        dp = new boolean[N+1][sum+1];
        for(int i=0;i<=N;i++){
            dp[i][0] = true;
        }

        for(int j=1;j<=sum;j++){
            dp[0][j] = false;
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }else{
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
        if(equalPartition(n,arr)==1){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
