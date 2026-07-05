class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> diary = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int n = candidates.length;
        
        fun(candidates,n,0,0,diary,res,target);
        return res;
    }

    void fun(int[] a,int n,int idx,int sum,List<Integer> diary,List<List<Integer>> res,int target ){
        if(idx==n){
            if(sum==target){
                res.add(new ArrayList<>(diary));
            }
            return;
        }

        fun(a,n,idx+1,sum,diary,res,target);

        if(a[idx]+sum<=target){
            diary.add(a[idx]);
            sum = sum+a[idx];
            fun(a,n,idx,sum,diary,res,target);
            diary.remove(diary.size() - 1);
            sum = sum-a[idx];
        }
    }
}