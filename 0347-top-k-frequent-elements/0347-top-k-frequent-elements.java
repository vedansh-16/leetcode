class Solution {
    class Pair{
        int first;
        int second;
        Pair(int f,int s){
            first = f;
            second = s;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.first - b.first
        );

         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int element = entry.getKey();
            int value = entry.getValue();

            Pair p = new Pair(value,element);

            if(pq.size()<k){
                pq.add(p);
                continue;
            }

            if(p.first<pq.peek().first){
                continue;
            }else{
                pq.poll();
                pq.add(p);
            }
        }
        int res[] = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            res[i] = pq.peek().second;
            pq.poll();
            i++;
        }
        
        return res;
    }
}
// class Solution {
//     class Pair{
//         int first;
//         int second;
//         Pair(int f,int s){
//             first = f;
//             second = s;
//         }
//     }
//     public int[] topKFrequent(int[] nums, int k) {
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int n : nums){
        //     map.put(n,map.getOrDefault(n,0)+1);
        // }

        // PriorityQueue<Pair> pq = new PriorityQueue<>(
        //     (a,b) -> b.second - a.second
        // );

//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             int key = entry.getKey();
//             int value = entry.getValue();

//             pq.add(new Pair(key,value));
//         }
//         int[] ans = new int[k];
        
//         for(int i=0;i<ans.length;i++){
//             Pair p = pq.poll();
//             ans[i] = p.first;
//         }

//         return ans;
//     }
// }