package examples.week1;

import java.util.Scanner;

public class TargetSum {

    static int[][] dp;
    static int findTargetSumWays(int[] A , int N, int target) {
        // code here
        if(N==0){
            return 0;
        }
        int sum =0;
        for(int i=0;i<N;i++){
            sum += A[i];
        }
        if((target+sum)%2!=0){
            return 0;
        }
        int subsetSum = (target+sum)/2;

        dp = new int[N+1][subsetSum+1];


        for(int i=0;i<=N;i++){
            dp[i][0]=1;
        }

        for(int j=1;j<=subsetSum;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=subsetSum;j++){
                if(A[i-1]<=j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-A[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
                //System.out.println(dp[i][j]);
            }
        }
        return dp[N][subsetSum];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        System.out.println(findTargetSumWays(arr,n,sum));
    }

}
