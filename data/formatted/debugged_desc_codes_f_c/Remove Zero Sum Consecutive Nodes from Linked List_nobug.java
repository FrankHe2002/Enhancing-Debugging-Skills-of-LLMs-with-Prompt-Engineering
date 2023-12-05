```java
// Runtime: 2 ms (Top 92.2%) | Memory: 43.00 MB (Top 67.8%)

import java.util.HashMap;
import java.util.Map;

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int prefix = 0;
        ListNode curr = dummy;
        Map<Integer, ListNode> seen = new HashMap<>();
        seen.put(prefix, dummy);

        while (curr != null) {
            prefix += curr.val;
            if (seen.containsKey(prefix)) {
                dummy = seen.get(prefix).next;
                int p = prefix + dummy.val;
                while (p != prefix && dummy != curr) {
                    seen.remove(p);
                    dummy = dummy.next;
                    p += dummy.val;
                }
                seen.get(prefix).next = curr.next;
                prefix += curr.val;
            } else {
                seen.put(prefix, curr);
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
```