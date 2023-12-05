```java
// Runtime: 1 ms (Top 69.17%) | Memory: 44 MB (Top 66.95%)
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] arr = new ListNode[k];

        if (head == null) {
            return arr;
        }

        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int partition = len / k; // Number of parts
        int extra = len % k; // Extra nodes

        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            arr[i] = curr;
            int partSize = partition + (extra-- > 0 ? 1 : 0);
            for (int j = 0; j < partSize - 1; j++) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }

        return arr;
    }
}
```