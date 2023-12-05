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

        while (temp != null) {
            ListNode temp1 = temp.next;
            int max = 0; // Initialize to 0

            while (temp1 != null) {
                if (temp1.val > temp.val) { // Compare with temp.val
                    max = temp1.val;
                    res[i] = max;
                    break;
                }

                temp1 = temp1.next;
            }
            temp = temp.next;
            i++;
        }
        res[i - 1] = 0; // Set last element to 0 if max not found
        return res;
    }
}
```