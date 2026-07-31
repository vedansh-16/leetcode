class Solution {
    class Pair{
        String first;
        int second;
        Pair(String f,int s){
            first = f;
            second = s;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(wordList.get(i),1);
        }

        if(!map.containsKey(beginWord)){
            map.put(beginWord,1);
        }

        if(!map.containsKey(endWord)){
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        map.remove(beginWord);

        while(!q.isEmpty()){
            Pair p = q.poll();
            String s = p.first;
            int val = p.second;

            if(s.equals(endWord)){
                return val;
            }

            char[] arr = s.toCharArray();

           for (int i = 0; i < arr.length; i++) {

                char c = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    if (ch == c) {
                        continue;
                    }

                    arr[i] = ch;

                    String next = new String(arr);

                    if (map.containsKey(next)) {
                        q.offer(new Pair(next, val + 1));
                        map.remove(next); 
                    }
                }

                arr[i] = c;
            }
        }
        return 0;
    }
}