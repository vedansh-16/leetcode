class Solution {
    public int majorityElement(int[] nums) {
    //     Map <Integer,Integer> map = new HashMap<>();
    //     for(int i = 0;i<n;i++){
    //         map.put(nums[i],map.getOrDefault(nums[i],0)+1);

    //         if(map.get(nums[i])>n/2){
    //         return nums[i];
    //     }
    // } 
    //     return -1;

    int king = 0;
    int vote = 0;

    for(int n:nums){
        if(vote == 0){
            king = n;
        }
        if(king == n){
            vote++;
        }
        else{
            vote--;
        }
    }
    return king;
    }
}