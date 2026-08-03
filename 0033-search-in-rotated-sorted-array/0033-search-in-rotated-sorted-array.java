class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low<high){
            int mid = (low + high)/2;

            if(nums[mid]>nums[high]){
                low = mid+1;
            }else{
                high = mid;
            }
        }

        int pivot = low;

        int low1 = pivot;
        int high1 = nums.length-1;

        int low2 = 0;
        int high2 = pivot-1;

        if(target>=nums[low1] && target<=nums[high1]){
            while(low1<=high1){
                int mid1 = (low1+high1)/2;

                if(nums[mid1]<target){
                    low1 = mid1+1;
                }else if(nums[mid1]>target){
                    high1 = mid1-1;
                }else{
                    return mid1;
                }
            }
        }

        if(pivot>0 && target>=nums[low2] && target<=nums[high2]){
            while(low2<=high2){
                int mid2 = (low2+high2)/2;

                if(nums[mid2]<target){
                    low2 = mid2+1;
                }else if(nums[mid2]>target){
                    high2 = mid2-1;
                }else{
                    return mid2;
                }
            }
        }

        return -1;
    }
}