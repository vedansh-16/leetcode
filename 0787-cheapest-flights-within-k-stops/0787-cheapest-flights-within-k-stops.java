class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int inf = (int)1e8;
        int[] res = new int[n];
        Arrays.fill(res,inf);
        res[src]=0;

        for(int i=0 ; i<=k ; i++){
            int[] temp = Arrays.copyOf(res,n);
            
            for(int j=0 ; j<flights.length ; j++){
                int s = flights[j][0];
                int d = flights[j][1];
                int wt = flights[j][2];

                if(res[s]!=inf && temp[d]>res[s]+wt){
                    temp[d] = res[s]+wt;
                }
            }
            res = temp;
        }

        if(res[dst]==inf){
            return -1;
        }

        return res[dst];
    }
}