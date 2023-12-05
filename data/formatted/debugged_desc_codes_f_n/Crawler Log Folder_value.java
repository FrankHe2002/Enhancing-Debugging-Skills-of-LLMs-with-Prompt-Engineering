Fix:
```java
// Runtime: 2 ms (Top 58.89%) | Memory: 37.6 MB (Top 94.57%)
class Solution {
    public int minOperations(String[] logs) {
        var stack = new Stack<String>();
        for (var log : logs) {
            if (log.equals("../")) {
                if (!stack.empty())
                    stack.pop();
            } else if (log.equals("./")) {
                // Remain in the same folder
            } else {
                stack.push(log);
            }
        }
        return stack.size();
    }
}
```