class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int low = 0;
        int res = 0;
        for(int high=0 ; high<s.length() ; high++){
            freq[s.charAt(high) - 'A']++;
            int len = high - low + 1;
            int maxcnt = find(freq);
            int diff = len - maxcnt;

            while(diff>k){
                freq[s.charAt(low) - 'A']--;
                low++;
                maxcnt = find(freq);
                len = high - low + 1;
                diff = len - maxcnt;
            }

            len = high - low + 1;
            res = Math.max(res,len);
        }
        return res;
    }

    int find(int[] freq){
        int count = 0;
        for(int i=0;i<26;i++){
            count=Math.max(count,freq[i]);
        }
        return count;
    }
}