class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int peak = 0;
        if(low==high){
            return low;
        }
        
        while(low<high){
            int guess = (low+high)/2;

            if(nums[guess]<nums[guess+1]){
                low = guess + 1;
            }else{
                high = guess;
            }

        }
        return low;
    }
}