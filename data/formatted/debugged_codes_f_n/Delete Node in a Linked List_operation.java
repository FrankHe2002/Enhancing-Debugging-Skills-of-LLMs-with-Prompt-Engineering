// Runtime: 0 ms (Top 100.00*) | Memory: 44.5 MB (Top 10.41%)
class Solution {
    public void deleteNode(ListNode node) {

        //Copy next node val to current node.
        node.val = node.next.val;

        //Point node.next = node.next.next
        node.next = node.next.next;
    }
}