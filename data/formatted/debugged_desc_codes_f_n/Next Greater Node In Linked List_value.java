Fix:

```java
// Runtime: 721 ms (Top 25.59%) | Memory: 45.5 MB (Top 95.1%)
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode length = head;
        int l = 0;
        while (length != null) {
            length = length.next;
            l++;
        }
        int[] res = new int[l];
        int i = 0;
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (temp != null) {
            while (!stack.isEmpty() && temp.val > temp[stack.peek()]) {
                res[stack.pop()] = temp.val;
            }
            stack.push(index);
            index++;
            temp = temp.next;
        }
        return res;
    }
}
```