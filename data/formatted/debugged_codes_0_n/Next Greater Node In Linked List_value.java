```java
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
            int max = temp.val;
            boolean found = false;

            while (temp1 != null) {
                if (temp1.val > max) {
                    max = temp1.val;
                    res[i] = max;
                    found = true;
                    break;
                }

                temp1 = temp1.next;
            }

            if (!found) {
                res[i] = 0;
            }
            
            temp = temp.next;
            i++;
        }
        return res;
    }
}
```