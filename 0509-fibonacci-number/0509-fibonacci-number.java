//Memoization
// class Solution {
//     HashMap<Integer,Integer> dp = new HashMap<>();
    // public int fib(int n) {
    //     if(n==0 || n==1){
    //         return n;
    //     }

//         if(dp.containsKey(n)){
//             return dp.get(n);
//         }

//         int ans1 = fib(n-1);
//         int ans2 = fib(n-2);

//         int ans = ans1+ans2;
        
//         dp.put(n,ans);

//         return ans;
//     }
// }

//Tabulation
class Solution {
    public int fib(int n) {
        if(n==0 || n==1){
            return n;
        }

        int prev = 1;
        int prev_prev = 0;
        int ans=0;
        for(int i=2;i<=n;i++){
            ans = prev + prev_prev;
            prev_prev = prev;
            prev = ans;
        }

        return ans;
    }
}