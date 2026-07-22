class Solution {
    class Pair {
    int first, second;

    Pair(int f, int s) {
        first = f;
        second = s;
    }
}
    int x[] = {-1,1,0,0};
    int y[] = {0,0,-1,1};

    boolean valid(int i,int j,int n,int m){
        if(i<0||i>=n||j<0||j>=m){
            return false;
        }
        return true;
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>(); 
        int fresh = 0;
        int time = 0;

        for(int i=0 ; i<n ;i++){
            for(int j=0; j<m ;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j));
                    grid[i][j] = -2;
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        while(!q.isEmpty() && fresh>0){
            time++;
            int s = q.size();
            while(s!=0){
                Pair p = q.poll();
                int r = p.first;
                int c = p.second;
                for(int k=0;k<4;k++){
                    int row = r + x[k];
                    int col = c + y[k];
                    if(valid(row,col,n,m)&&grid[row][col]==1){
                        q.offer(new Pair(row,col));
                        grid[row][col] = -2;
                        fresh--;
                    }
                }
                s--;
            }
        }

        if(fresh>0){
            return -1;
        }

        return time;
    }
}


