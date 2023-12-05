```java
class Solution {
    HashMap<String, HashMap<Character, Integer>> map;

    public int minStickers(String[] stickers, String target) {
        map = new HashMap<>();
        for (String sticker : stickers) {
            HashMap<Character, Integer> temp = new HashMap<>();
            for (char ch : sticker.toCharArray())
                temp.put(ch, temp.getOrDefault(ch, 0) + 1);
            map.put(sticker, temp);
        }
        int count = memoization(target, new HashMap<>());
        return count < 1 || count >= Integer.MAX_VALUE ? -1 : count;
    }

    public int memoization(String target, HashMap<String, Integer> dpmap) {
        if (target.length() == 0) return 0;
        if (dpmap.containsKey(target)) return dpmap.get(target);
        int count = Integer.MAX_VALUE;
        for (String str : map.keySet()) {
            HashMap<Character, Integer> xd = new HashMap(map.get(str));
            String temp = target;
            while (temp.length() > 0) {
                char ch = temp.charAt(0);
                if (xd.containsKey(ch)) {
                    if (xd.get(ch) > 0) {
                        xd.put(ch, xd.get(ch) - 1);
                    } else {
                        xd.remove(ch);
                    }
                }
                temp = temp.substring(1);
            }
            if (temp.length() < target.length()) {
                count = Math.min(count, 1 + memoization(temp, dpmap));
                dpmap.put(target, count);
            }
        }
        return count;
    }
}
```