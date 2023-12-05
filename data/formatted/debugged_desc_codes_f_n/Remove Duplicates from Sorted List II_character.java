```java
// Runtime: 3 ms (Top 8.62% | Memory: 43.1 MB (Top 83.93%)
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode temp = head;
        int last = -1;
        int[] array = new int[201];
        
        while (temp != null) {
            array[temp.val + 100]++;
            temp = temp.next;
        }
        for (int i = 0; i < 201; i++) {
            if (array[i] == 1) {
                last = i;
            }
        }
        if (last == -1) return null;
        temp = head;
        ListNode newHead = new ListNode();
        ListNode newCurr = newHead;

        for (int i = 0; i < 201; i++) {
            if (array[i] == 1) {
                newCurr.next = new ListNode(i - 100);
                newCurr = newCurr.next;
            }
        }
        return newHead.next;
    }
}```