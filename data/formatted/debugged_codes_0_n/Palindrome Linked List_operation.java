```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMiddle(head);
        ListNode headSecond = reverse(mid);
        ListNode reverseHead = headSecond;
        boolean isPalindrome = true;
        
        while (head != null && headSecond != null) {
            if (head.val != headSecond.val) {
                isPalindrome = false;
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        
        reverse(reverseHead);
        
        return isPalindrome;
    }

    public ListNode reverse(ListNode head) {
        if (head == null) return head;
        ListNode prev = null;
        ListNode present = head;
        ListNode next = head.next;
        
        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        
        return prev;
    }

    public ListNode getMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}
```