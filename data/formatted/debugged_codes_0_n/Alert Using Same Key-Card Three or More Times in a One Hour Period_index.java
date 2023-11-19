```java
class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            PriorityQueue<Integer> pq = map.getOrDefault(keyName[i], new PriorityQueue<Integer>());
            pq.add(Integer.parseInt(keyTime[i].substring(0, 2)) * 100 + Integer.parseInt(keyTime[i].substring(3)));
            map.put(keyName[i], pq);
        }

        List<String> ans = new ArrayList<>();
        for (String s : map.keySet()) {
            PriorityQueue<Integer> pq = map.get(s);
            if (active(pq)) {
                ans.add(s);
            }
        }

        Collections.sort(ans);
        return ans;
    }

    private boolean active(PriorityQueue<Integer> pq) {
        if (pq.size() < 3) return false;
        int a = pq.poll();
        int b = pq.poll();
        int c = pq.poll();
        if (c - a <= 100) return true;
        while (pq.size() > 0) {
            a = b;
            b = c;
            c = pq.poll();
            if (c - a <= 100) return true;
        }
        return false;
    }
}
```