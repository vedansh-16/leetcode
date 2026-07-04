class Solution {
    public int maximumSum(int[] arr) {
        int noDel = arr[0];
        int oneDel = Integer.MAX_VALUE;
        int result = arr[0];

        for(int i = 1; i < arr.length; i++){
            int prevnoDel = noDel;
            int prevoneDel = oneDel;
            noDel = Math.max(noDel+arr[i],arr[i]);
            int v2;
            if(oneDel == Integer.MAX_VALUE){
                v2 = arr[i];
            }else{
                v2 = prevoneDel + arr[i];
            }

            oneDel = Math.max(v2,prevnoDel);

            result =  Math.max(result,Math.max(noDel,oneDel));
        }
        return result;
    }
}