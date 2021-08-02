package examples.week1;

import java.util.Scanner;

public class BoundedKnapsack {

    static int[][] dp = new int[1001][1001];
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // your code here
        if(W==0 || n==0){
            return 0;
        }


        for(int i=0;i<W;i++){
            dp[0][i]=0;
        }

        for(int j=0;j<n;j++){
            dp[j][0]=0;
        }

        for(int k=1;k<=n;k++){
            for(int l=1;l<=W;l++){
                if(wt[k-1]>l){
                    dp[k][l]=dp[k-1][l];
                }else{
                    int in = dp[k-1][l-wt[k-1]] + val[k-1];
                    int exclude = dp[k-1][l];
                    dp[k][l] = max(in,exclude);
                }
            }
        }
        return dp[n][W];
    }

    static int max(int a,int b){
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
        System.out.println(knapSack(weight,weightArray,values,n));
    }
}
