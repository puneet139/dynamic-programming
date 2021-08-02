package examples.week1;

import java.util.Scanner;

public class UnboundedKnapsack {

    static int[][] dp;
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        dp = new int[N+1][W+1];
        for(int i=0;i<N;i++){
            dp[i][0]=0;
        }

        for(int j=1;j<W;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=W;j++){
                if(wt[i-1]<=j){
                    int in = val[i-1] + dp[i][j-wt[i-1]];
                    int ex = dp[i-1][j];
                    dp[i][j] = max(in,ex);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }

    static int max(int a, int b){
        return (a>b?a:b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int weight = sc.nextInt();
        int[] values = new int[n];
        int[] weightArray = new int[n];
        for(int i=0;i<n;i++){
            values[i] = sc.nextInt();
        }

        for(int j=0;j<n;j++){
            weightArray[j] = sc.nextInt();
        }
        System.out.println(knapSack(n,weight,values,weightArray));
    }
}
