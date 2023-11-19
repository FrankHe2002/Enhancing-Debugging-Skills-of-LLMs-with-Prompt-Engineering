```java
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> arr = new ArrayList<Integer>();
        if (root == null) return arr;

        Stack<Node> stk = new Stack<Node>();
        stk.push(root);
        Node ref;
        while (! stk.empty()) {
            ref = stk.pop();
            arr.add(ref.val);
            for (int i = ref.children.size() - 1; i >= 0; i--) {
                stk.push(ref.children.get(i));
            }
        }
        return arr;
    }
}
```