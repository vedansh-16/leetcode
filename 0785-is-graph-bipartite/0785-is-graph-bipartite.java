class Solution {
    boolean res = true;

    void dfs(int[][] a,int node, int c, int[] colors){
        colors[node] = c;

        for(int i=0 ; i<a[node].length;i++){
            int neighbour = a[node][i];
            if(colors[neighbour]!=-1 && colors[neighbour]==c){
                res = false;
                return;
            }
            if(colors[neighbour]==-1){
                dfs(a,neighbour,1-c,colors);
            }
            
        }
    }

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] colors = new int[V];
        for(int i = 0; i < V; i++){
            colors[i] = -1;
        }

        for(int i=0; i<V; i++){
            if(colors[i]==-1){
                dfs(graph,i,0,colors);
            }
        }
        return res;
    }
}