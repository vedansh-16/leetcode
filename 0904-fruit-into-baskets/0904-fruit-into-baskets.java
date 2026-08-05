class Solution {
    public int totalFruit(int[] fruits) {
        int low = 0;
        int res = Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<>();

        for(int high = 0 ; high < fruits.length ; high++){
            int val = fruits[high];
            map.put(val,map.getOrDefault(val,0)+1);

            while(map.size()>2){
                int val2 = fruits[low];
                map.put(val2,map.get(val2)-1);

                if(map.get(val2)==0){
                    map.remove(val2);
                }
                low++;
            }

            int len = high - low + 1;
            res = Math.max(len,res);
            
        }
        return res;
    }
}