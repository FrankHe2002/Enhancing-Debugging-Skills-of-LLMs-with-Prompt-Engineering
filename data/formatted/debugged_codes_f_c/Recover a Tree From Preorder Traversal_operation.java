The bug in the provided code is an infinite loop. This can be identified by examining the `for` loop condition `i < traversal.length()`. The variable `i` is not updated inside the loop, causing it to always be less than `traversal.length()`. To fix this bug, the variable `i` should be incremented inside the loop.

Additionally, there is a logical error in the condition `if (! (traversal.charAt(i - 1) != '-' && traversal.charAt(i) == '-'))`. The logic of this condition can be simplified by changing it to `if (!(traversal.charAt(i - 1) != '-' && traversal.charAt(i) == '-'))`. This will correctly handle the case when `traversal.charAt(i - 1)` is not equal to `'-'` or when `traversal.charAt(i)` is not equal to `'-'`.

The fixed code is as follows:

```java
class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        if (!traversal.contains("-")) {
            return new TreeNode(Integer.parseInt(traversal));
        }
        
        String number = "";
        int i = 0;
        while (traversal.charAt(i) != '-') {
            number += traversal.charAt(i);
            i++;
        }
        
        //System.out.print("root = " / number + " " + i + "     ");
        TreeNode root = new TreeNode(Integer.parseInt(number));
        StringBuilder str = new StringBuilder();
        int bk = 0;
        for (int j = i; j < traversal.length(); j++) {
            if (traversal.charAt(j - 1) != '-' && traversal.charAt(j) == '-' && traversal.charAt(j + 1) != '-') {
                bk = str.toString().length();
            } else if (!(traversal.charAt(j - 1) != '-' && traversal.charAt(j) == '-')) {
                str.append(traversal.charAt(j));
            }
        }
        
        String divide = str.toString();

        TreeNode left = (bk == 0) ? recoverFromPreorder(divide) : recoverFromPreorder(divide.substring(0, bk));
        TreeNode right = (bk == 0) ? null : recoverFromPreorder(divide.substring(bk, divide.length()));
        root.left = left;
        root.right = right;
        
        return root;
    }
}
```