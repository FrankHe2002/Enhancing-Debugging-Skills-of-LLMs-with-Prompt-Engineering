Bug Type: Incorrect assignment in the `while` loop

Reasoning: In the `while` loop for merging `list1` and `list2`, there is a subtle bug where `list2.next` is assigned `l1Next` instead of `l2Next`. This results in incorrect linking of nodes and affects the merging of the two lists.

Fix: Replace `list2.next = l1Next;` with `list2.next = l2Next;`