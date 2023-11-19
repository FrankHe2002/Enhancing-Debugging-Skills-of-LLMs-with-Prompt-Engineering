```java
// Runtime: 5 ms (Top 88.69%) | Memory: 40.1 MB (Top 99.82%)
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
        ListNode temp1;

        while (temp != null) {
            temp1 = temp.next;
            int max = temp.val;

            while (temp1 != null) {
                if (temp1.val > max) {
                    max = temp1.val;
                    break;
                }
                temp1 = temp1.next;
            }
            res[i] = max;
            temp = temp.next;
            i++;
        }
        return res;
    }
}
```