class Solution {
    public int majorityElement(int[] nums) {
        int king  = nums[0];
        int vote = 1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]==king){
                vote++;
            }else{
                vote--;
                
            }

            if(vote == 0){
                king = nums[i];
                vote = 1;
            }
        }

        return king;
    }
}