class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];

        int count = 0;

        for(int i=0;i<n;i++){
            if(visited[i] == 0){
                dfs(i,isConnected,visited,n);
                count++;
            }
        }

        return count;
    }

    void dfs(int node,int[][] a,int[] visited,int n){
        visited[node] = 1;
        
        for(int i=0;i<n;i++){
            if(a[node][i]==1 && visited[i]==0){
                dfs(i,a,visited,n);
            }
        }
    }
}