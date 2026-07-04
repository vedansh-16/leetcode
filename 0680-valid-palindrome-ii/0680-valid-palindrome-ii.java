class Solution {
    public boolean validPalindrome(String s) {
        int left = 0 , right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                int i = left+1 , j = right;
                boolean skipLeft = true;
                while(i<j){
                    if(s.charAt(i)!=s.charAt(j)){
                        skipLeft = false;
                        break;
                    }
                    i++;
                    j--;
                }
                i = left;
                j=right-1;
                boolean skipRight = true;
                while(i<j){
                    if(s.charAt(i)!=s.charAt(j)){
                        skipRight = false;
                    }
                    i++;
                    j--;  
                }   
                return skipRight || skipLeft;
            }
            left ++;
            right --;
        }
        return true;
    }
}