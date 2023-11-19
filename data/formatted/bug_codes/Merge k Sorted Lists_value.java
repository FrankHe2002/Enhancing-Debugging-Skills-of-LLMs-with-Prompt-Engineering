class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) return null;
        ListNode res = lists[0];
        for (int i = 1; i < lists.length; i++) {
            res = mergeTwo(res, lists[i]);
        }

        return res;
    }

    private ListNode mergeTwo(ListNode l1, ListNode l2) {
        if (l - 1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwo(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwo(l2.next, l1);
            return l2;
        }
    }
}