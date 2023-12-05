```java
// Runtime: 1 ms (Top 69.17%) | Memory: 43.9 MB (Top 66.95%)
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] arr = new ListNode[k];

        if (k < 2 || head == null) {
            if (head != null) {
                arr[0] = head;
            }
            return arr;
        }

        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int partition = len / k; //no of part 3
        int extra = len % k; //extra node 1 0

        ListNode curr = head;
        int index = 0;
        while (curr != null) {
            arr[index++] = curr;
            int size = partition + (extra-- > 0 ? 1 : 0);
            for (int i = 0; i < size - 1; i++) {
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