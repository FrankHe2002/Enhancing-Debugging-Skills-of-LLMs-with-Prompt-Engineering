```java
class Solution {
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        String[] lines = input.split("\n");
        for (String line : lines) {
            int tabs = countTabs(line);
            while (stack.size() > tabs) {
                stack.pop();
            }
            int current = stack.isEmpty() ? 0 : stack.peek();
            int nameLength = line.length() - tabs;
            if (isFilename(line)) {
                max = Math.max(max, current + nameLength);
            } else {
                stack.push(current + nameLength + 1);
            }
        }
        return max;
    }

    private int countTabs(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\t') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private boolean isFilename(String s) {
        return s.lastIndexOf(".") != - 1;
    }
}
```
