class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(nums,n,0,1,dp);
    }

    int fun(int[] nums,int n,int i,int freeChoice,int[][] dp){
        if(i==n){
            return 0;
        }

        if(dp[i][freeChoice]!=-1){
            return dp[i][freeChoice];
        }

        if(freeChoice == 0){
            int a1 = fun(nums,n,i+1,1,dp);
            dp[i][freeChoice] = a1;
            return a1;
        }

        int c1 = nums[i] + fun(nums,n,i+1,0,dp);
        int c2 = fun(nums,n,i+1,1,dp);

        int ans = Math.max(c1,c2); 
        dp[i][freeChoice] = ans;
        return ans;
    }
}