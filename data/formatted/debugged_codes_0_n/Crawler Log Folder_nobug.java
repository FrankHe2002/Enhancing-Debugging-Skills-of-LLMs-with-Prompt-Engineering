```java
class Solution {
    public int minOperations(String[] logs) {
        var stack = new Stack<String>();
        for (var log : logs) {
            if (log.equals("../")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else if (!log.equals("./")) {
                stack.push(log);
            }
        }
        return stack.size();
    }
}
```