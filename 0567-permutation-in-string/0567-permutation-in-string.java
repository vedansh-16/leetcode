class Solution {
    boolean check(int[] arr1,int[] arr2){
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        
        for(int i = 0;i<s1.length();i++){
            freq1[s1.charAt(i) - 'a']++;
        }

        for(int i = 0;i<s1.length();i++){
            freq2[s2.charAt(i) - 'a']++;
        }

        if(check(freq1,freq2)){
            return true;
        }

        int low = 0;

        for(int high = s1.length();high<s2.length();high++){
            freq2[s2.charAt(low) - 'a']--;
            low++;

            freq2[s2.charAt(high) - 'a']++;

            if(check(freq1,freq2)){
                return true;
            }
        }
        return false;
    }
}