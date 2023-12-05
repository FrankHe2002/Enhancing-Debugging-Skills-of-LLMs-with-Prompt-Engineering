```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> values = new Stack<>();
        ListNode current = head;
        while (current != null) {
            values.push(current.val);
            current = current.next;
        }
        while (head != null) {
            if (head.val != values.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
```