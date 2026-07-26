class Solution {
    class Pair{
        int first;int second;int third;
        Pair(int f,int s,int t){
            first= f;
            second= s;
            third= t;
        }
    }
    boolean valid(int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m){
            return false;
        }
        return true;
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] res = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(res[i],Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)-> a.first - b.first
        );

        res[0][0] = 0;
        pq.add(new Pair(0,0,0));

        int[] x ={-1,1,0,0};
        int[] y ={0,0,-1,1};

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int dis = p.first;
            int row = p.second;
            int col = p.third;

            if(dis>res[row][col]){
                continue;
            }

            for(int k=0;k<4;k++){
                int r = row + x[k];
                int c = col + y[k];

                if(!valid(r,c,n,m)){
                    continue;
                }

                int absDiff = Math.abs(heights[row][col]-heights[r][c]);
                int newWt = Math.max(absDiff,dis);

                if(newWt < res[r][c]){
                    res[r][c] = newWt;
                    pq.add(new Pair(newWt,r,c));
                }
            }
        }
        return res[n-1][m-1];
    }
}