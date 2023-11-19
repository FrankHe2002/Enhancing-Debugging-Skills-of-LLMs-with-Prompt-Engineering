class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode temp = head;
        int last = - 1;
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
        if (last == - 1) return null;
        temp = head;

        for (int i = 0; i < 201; i++) {
            if (array[i] == 1) {
                temp.val = i - 100;
                if (i == last) {
                    temp.next = null;
                    break;
                }
                temp = temp.next;
            }
        }
        temp.next = null;

        return head;
    }
}```