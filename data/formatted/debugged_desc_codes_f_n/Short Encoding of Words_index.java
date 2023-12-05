```java
// Runtime: 23 ms (Top 85.71%) | Memory: 59.1 MB (Top 35.19%)
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
            if (i == 0 && node.getFlag()) {
                count -= word.length() + 1;
                node.setFlag(false);
            }
        }
        if (!flag) 
            node.setFlag(true);

        return flag ? count : count + word.length() + 1;
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