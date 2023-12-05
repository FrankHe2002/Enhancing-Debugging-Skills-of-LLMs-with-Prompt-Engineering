```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode newList = new ListNode(0);
        ListNode newHead = newList;
        ListNode newtemp = newList;
        /*---------------------------------------------------------------*/
        int sum = 0;
        if (head == null && head.next == null) return head;
        /*---------------------------------------------------------------*/
        ListNode temp = head;
        while (temp.next != null) {  //traverse linkelist
            temp = temp.next;
            sum += temp.val;  //sum elements until zero
            if (temp.val == 0) {
                ListNode node = new ListNode(sum); //create a new node;
                newtemp.next = node; //connect with dummy node which is created initially
                newtemp = newtemp.next; //shift pointer to newly created node
                sum = 0; //reset sum
            }
        }
        /*---------------------------------------------------------------*/
        return newHead.next; //skip dummy node which is created initially
    }
}
```