class Solution {
    public int longestPalindrome(String s) {
        Map <Character,Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        boolean odd =false;
        int res = 0;

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            int val = entry.getValue();

            if(val % 2 == 0){
                res = res + val;
            }else{
                res = res + val - 1;
                odd = true;
            }
        }

        if(odd==true){
            res++;
        }

        return res;
    }
}