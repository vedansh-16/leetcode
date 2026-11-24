class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        HashMap <Character,Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }   

        for(char ch : t.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch,map.getOrDefault(ch,0)-1);

                if(map.get(ch)==0){
                    map.remove(ch);
                }
            }
        }

        if(map.size()==0){
            return true;
        }

        return false;
    }
}