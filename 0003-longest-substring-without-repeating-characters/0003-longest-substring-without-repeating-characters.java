class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int low = 0;
        int ans = 0;
        for(int high = 0;high<s.length();high++){
            char ch = s.charAt(high);
            map.put(ch,map.getOrDefault(ch,0)+1);

            int len = high - low + 1;

            while(map.size()<len){
                char c = s.charAt(low);
                map.put(c,map.getOrDefault(c,0)-1);
                low++;

                if(map.get(c)==0){
                    map.remove(c);
                }

                len = high - low + 1;
            }

             ans = Math.max(len,ans);
        }
        return ans;
    }
}