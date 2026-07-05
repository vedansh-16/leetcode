class Solution {
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        StringBuilder temp = new StringBuilder();
        List<String> res = new ArrayList<>();
        HashMap<Character,String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        fun(digits,n,0,temp,res,map);   
        return res; 
    }

    void fun(String digits,int n,int idx,StringBuilder temp,List<String> res,HashMap<Character,String> map){
        if(idx==n){
            res.add(temp.toString());
            return;
        }

        String choice = map.get(digits.charAt(idx));

        for(int i = 0;i<choice.length();i++){
            temp.append(choice.charAt(i));
            fun(digits,n,idx+1,temp,res,map);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}