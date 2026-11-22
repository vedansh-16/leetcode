class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : text.toCharArray()) {
            if (c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        if (map.size() == 5 && map.get('l') >= 2 && map.get('o') >= 2) {
            int res = Math.min(map.get('b'), map.get('a'));
            res = Math.min(res, Math.min(map.get('l') / 2, map.get('o') / 2));
            res = Math.min(res, map.get('n'));

            return res;
        }

        return 0;
    }
}