```java
// Runtime: 7 ms (top 86.45%) | Memory: 39 MB (top 76.07%)
class MyLinkedList {

    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int length;

    public MyLinkedList() {
        length = 0;
    }

    public int get(int index) {
        if (index >= length || index < 0) return -1;
        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        head = new ListNode(val, head);
        if (length == 0) {
            tail = head;
        }
        length++;
    }

    public void addAtTail(int val) {
        if (length == 0) {
            addAtHead(val);
            return;
        }
        tail.next = new ListNode(val);
        tail = tail.next;
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index > length) return;
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index == length) {
            addAtTail(val);
            return;
        }
        ListNode temp = head;
        for (int i=0; i<index-1; i++) {
            temp = temp.next;
        }
        temp.next = new ListNode(val, temp.next);
        length++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) return;
        if (index == 0) {
            head = head.next;
            length--;
            if (length == 0) {
                tail = null;
            }
            return;
        }
        ListNode temp = head;
        for (int i=0; i<index-1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        if (index == length-1) {
            tail = temp;
        }
        length--;
    }
}
```