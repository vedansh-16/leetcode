class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low = 0;
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();

        for(int high=0;high<s.length();high++){
            char ch = s.charAt(high);
            map.put(ch,map.getOrDefault(ch,0)+1);
            int len = high - low + 1;

            while(len>map.size()){
                char c = s.charAt(low);
                map.put(c,map.getOrDefault(c,0)-1);

                if(map.get(c) == 0){
                    map.remove(c);
                }

                low++;
                len = high - low + 1;
            }

            
            res = Math.max(len,res);
        }  

        return res;
    }
}