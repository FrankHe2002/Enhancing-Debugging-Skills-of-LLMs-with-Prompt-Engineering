```java
// Runtime: 98 ms (Top 88.24%) | Memory: 61 MB (Top 77.65%)
class Solution {
    public int openLock(String[] deadends, String target) {
        int t = Integer.parseInt(target);
        HashSet<Integer> visited = new HashSet<>();
        for (String str : deadends) {
            visited.add(Integer.parseInt(str));
        }
        Queue<Integer> q = new ArrayDeque<>();
        if (visited.contains(0)) {
            return - 1;
        }
        q.add(0);
        visited.add(0);
        int level = 0;
        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                int elem = q.remove();
                if (t == elem) {
                    return level;
                }
                for (int i = 1; i < 10000; i = i * 10) {
                    int num1;
                    int num2;
                    if (elem / i % 10 == 0) {
                        num1 = elem + i;
                        num2 = elem + i * 9;
                    } else if (elem / i % 10 == 9) {
                        num1 = elem - i * 9;
                        num2 = elem - i;
                    } else {
                        num1 = elem - i;
                        num2 = elem + i;
                    }
                    if (!visited.contains(num1)) {
                        visited.add(num1);
                        q.add(num1);
                    }
                    if (!visited.contains(num2)) {
                        visited.add(num2);
                        q.add(num2);
                    }
                }
            }
            level++;
        }
        return - 1;
    }
}
```