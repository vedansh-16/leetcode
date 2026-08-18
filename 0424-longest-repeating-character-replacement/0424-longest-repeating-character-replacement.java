class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int res = 0;
        int low = 0;
        for(int high=0;high<s.length();high++){
            char c = s.charAt(high);
            freq[c - 'A']++;
            int len = high-low+1;
            int maxcnt = find(freq);
            int diff = len - maxcnt;

            while(diff>k){
                char ch = s.charAt(low);
                freq[ch - 'A']--;

                low++;

                len = high - low + 1;
                maxcnt = find(freq);
                diff = len - maxcnt;
            }

            len = high-low+1;
            res = Math.max(res,len);

        }
        return res;
        
    }

    int find(int[] a){
        int ans = 0;
        for(int i=0;i<26;i++){
           ans = Math.max(ans,a[i]);
        }

        return ans;
    }
}