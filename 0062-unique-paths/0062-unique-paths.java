class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }

        return fun(m,n,0,0,dp);
    }
    int fun(int m,int n,int i,int j,int[][] dp){
        if(i==n-1 && j==m-1){
            return 1;
        }
        if(i>=n || i<0 || j>=m || j<0){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        return dp[i][j] = fun(m,n,i+1,j,dp) + fun(m,n,i,j+1,dp);
    }
}