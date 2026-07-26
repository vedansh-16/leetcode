class Solution {
    class Pair{
        int first; int second;
        Pair(int f,int s){
            first = f;
            second = s;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int src = times[i][0]-1;
            int dest = times[i][1]-1;
            int wt = times[i][2];

            adj.get(src).add(new Pair(dest,wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) ->{
                if(a.first!=b.first){
                    return a.first-b.first;
                }
                return a.second-b.second;
            }
        );

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1]=0;

        pq.add(new Pair(0,k-1));//<distance,node>

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int d = p.first;
            int node = p.second;

            if(d>dist[node]){
                continue;
            }

            for(int j=0; j<adj.get(node).size(); j++){
                int neighbour = adj.get(node).get(j).first;
                int wt = adj.get(node).get(j).second;

                if((d+wt)<dist[neighbour]){
                    dist[neighbour]=d+wt;
                    pq.add(new Pair(d+wt,neighbour));
                }
            }
        } 

        int ans = 0;

        for(int i=0;i<dist.length;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans,dist[i]);
        }

        return ans;
    }
}