```java
class Solution {
    
    private Map<Integer, Map<Character, Integer>> memo;
    private boolean hasCycle;
    
    public int largestPathValue(String colors, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int edge[] : edges) {
            List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            map.put(edge[0], list);
        }

        memo = new HashMap<>();
        int max = 0;
        hasCycle = false;

        for (int i = 0; i < colors.length(); i++) {
            dfs(i, map, colors);
        }

        if (hasCycle) {
            return -1;
        }

     
        return max;
    }

    private void dfs(int curr, Map<Integer, List<Integer>> map, String colors) {
        if (hasCycle) {
            return;
        }
        
        if (memo.containsKey(curr)) {
            return;
        }
        
        Map<Character, Integer> currMap = new HashMap<>();
        currMap.put(colors.charAt(curr), 1);
        memo.put(curr, currMap);

        List<Integer> list = map.get(curr);
        if (list != null) {
            for (int i : list) {
                if (i == curr) {
                    hasCycle = true;
                    return;
                }
                Map<Character, Integer> resMap = memo.getOrDefault(i, new HashMap<>());
                int currMax = 0;
                for (char c : resMap.keySet()) {
                    int newVal = resMap.get(c);
                    currMap.put(c, currMap.getOrDefault(c, 0) + newVal);
                    currMax = Math.max(currMax, currMap.get(c));
                }
                max = Math.max(currMax, max);
                dfs(i, map, colors);
            }
        }
    }
}
```