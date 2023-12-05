The bug in the given Java code is a typo in the Node class. In the `getChild()` method, there is a typographical error in using an undefined variable `ms`. It should be `index` instead.

Steps to fix the bug:
1. In the Node class, change `getChild(int index) { return children[ms]; }` to `getChild(int index) { return children[index]; }`.

Here's the updated code:

```java
import java.util.Arrays;

class Node {
    private boolean flag;
    private Node[] children;

    public Node() {
        flag = false;
        children = new Node[26];
        Arrays.fill(children, null);
    }

    public boolean getFlag() {
        return flag;
    }

    public Node getChild(int index) {
        return children[index];
    }

    public boolean hasChild(int index) {
        return children[index] != null;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void makeChild(int index) {
        children[index] = new Node();
    }
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public int addWord(String word) {

        boolean flag = true;
        Node node = root;
        int count = 0;

        for (int i = word.length() - 1; i >= 0; --i) {
            int index = (int) word.charAt(i) - 97;

            if (!node.hasChild(index)) {
                flag = false;
                node.makeChild(index);
            }

            node = node.getChild(index);
            if (node.getFlag()) {
                node.setFlag(false);
                count -= word.length() - i + 1;

                if (i == 0)
                    flag = false;
            }
        }

        if (!flag)
            node.setFlag(true);

        return flag ? count : count + 1 + word.length();
    }
}

class Solution {
    public int minimumLengthEncoding(String[] words) {
        Trie trie = new Trie();
        int size = 0;

        for (String word : words) {
            size += trie.addWord(word);
        }

        return size;
    }
}
```