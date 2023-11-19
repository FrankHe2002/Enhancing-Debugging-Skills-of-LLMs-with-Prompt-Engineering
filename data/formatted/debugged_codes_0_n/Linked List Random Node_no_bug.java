class Solution {
    int N = 0;
    ListNode head = null;

    public Solution(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        ListNode p = this.head;
        int i = 1, ans = 0;
        while (p != null) {
            if (Math.random() * i < 1) ans = p.val;
            p = p.next;
            i++;
        }
        return ans;
    }
}