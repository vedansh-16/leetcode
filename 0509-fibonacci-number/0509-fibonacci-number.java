class Solution {
    HashMap<Integer,Integer> dp = new HashMap<>();
    public int fib(int n) {
        if(n==0 || n==1){
            return n;
        }

        if(dp.containsKey(n)){
            return dp.get(n);
        }

        int ans1 = fib(n-1);
        int ans2 = fib(n-2);

        int ans = ans1+ans2;
        
        dp.put(n,ans);

        return ans;
    }
}