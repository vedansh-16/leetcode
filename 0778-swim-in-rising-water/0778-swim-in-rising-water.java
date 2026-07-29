//1. Binary Search Solution
// class Solution {
//     public int swimInWater(int[][] grid) {
//         int n = grid.length;
//         int low = grid[0][0];
//         int high = grid[0][0];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 high = Math.max(high,grid[i][j]);
//             }
//         }

//         int res = 0;

//         while(low<=high){
//             int guess = (low+high)/2;
//             if(bfs(grid,n,n,guess)){
//                 res=guess;
//                 high = guess - 1;
//             }
//             else{
//                 low = guess+1;
//             }
//         }
//         return res;
//     }

//     boolean bfs(int[][] a,int n,int m,int money){
//         int[] x = {1,-1,0,0};
//         int[] y = {0,0,1,-1};
//         Queue<int[]> q = new LinkedList<>();
        
//         int[][] vis = new int[n][m];

//         for(int i=0;i<n;i++){
//             Arrays.fill(vis[i],0);
//         }

//         q.offer(new int[]{0,0});
//         vis[0][0]=1;

//         while(!q.isEmpty()){
//             int row = q.peek()[0];
//             int col = q.peek()[1];
//             q.poll();

//             if(row==n-1 && col == m-1){
//             return true;
//             }

//             for(int k=0;k<4;k++){
//                 int r = row + x[k];
//                 int c = col + y[k];
//                 if(valid(r,c,n,m) && vis[r][c]==0 && money>=a[r][c]){
//                     q.offer(new int[]{r,c});
//                     vis[r][c]=1;
//                 }
//             }
//         }
        
//         return false;
//     }

//     boolean valid(int i,int j,int n,int m){
//         if(i<0 || i>=n || j<0 || j>=m){
//             return false;
//         }
//         return true;
//     }
// }

//2. Dijkastra

class Solution {

    class Pair{
        int time,row,col;

        Pair(int time,int row,int col){
            this.time=time;
            this.row=row;
            this.col=col;
        }
    }

    boolean valid(int i,int j,int n,int m){
        return i>=0 && i<n && j>=0 && j<m;
    }

    public int swimInWater(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;

        int[][] dist=new int[n][m];

        for(int i=0;i<n;i++)
            Arrays.fill(dist[i],Integer.MAX_VALUE);

        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->a.time-b.time
        );

        dist[0][0]=grid[0][0];
        pq.add(new Pair(grid[0][0],0,0));

        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};

        while(!pq.isEmpty()){

            Pair cur=pq.poll();

            int time=cur.time;
            int row=cur.row;
            int col=cur.col;

            if(row==n-1 && col==m-1)
                return time;

            if(time>dist[row][col])
                continue;

            for(int k=0;k<4;k++){

                int r=row+dx[k];
                int c=col+dy[k];

                if(!valid(r,c,n,m))
                    continue;

                int newTime=Math.max(time,grid[r][c]);

                if(newTime<dist[r][c]){
                    dist[r][c]=newTime;
                    pq.add(new Pair(newTime,r,c));
                }
            }
        }

        return -1;
    }
}