Bug type: No bug

Reasoning:
- The code is trying to invert a binary tree by swapping the left and right subtrees of each node.
- The code recursively traverses the tree in a post-order traversal fashion (left -> right -> root).
- The function `invertTree` calls the helper function `swap` passing the root node.
- The `swap` function recursively traverses the tree and swaps the left and right subtrees for each node.
- The implementation looks correct and there doesn't seem to be any bug.

Fix:
No fix required as there is no bug in the provided code.