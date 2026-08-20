class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]); 
        arr2.add(nums[1]); 

        for(int i=2;i<nums.length;i++){
            int l1 = arr1.size();
            int l2 = arr2.size();

            if(arr1.get(l1-1) > arr2.get(l2-1)){
                arr1.add(nums[i]);
            }else{
                arr2.add(nums[i]);
            }
        }
        int res[] = new int[arr1.size()+arr2.size()];

        for(int i=0;i<arr1.size();i++){
            res[i] = arr1.get(i);
        }
        
        for(int i=0;i<arr2.size();i++){
            res[arr1.size()+i] = arr2.get(i);
        }

        return res;
    }
}