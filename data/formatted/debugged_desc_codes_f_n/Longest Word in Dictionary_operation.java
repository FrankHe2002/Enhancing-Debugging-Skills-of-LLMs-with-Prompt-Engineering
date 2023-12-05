Fix:

```java
class Solution {
    private class Node {
        Node[] sub;

        Node() {
            sub = new Node[26];
        }
    }

    Node root;
    String ans;

    private void buildTire(String word) {
        Node temp = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int index = word.charAt(i) - 'a';
            if (temp.sub[index] == null) {
                temp.sub[index] = new Node();
            }
            temp = temp.sub[index];
        }
        if (word.length() > ans.length())
            ans = word;
        if (word.length() == ans.length()) {
            ans = word.compareTo(ans) < 0 ? word : ans;
        }
    }

    public String longestWord(String[] words) {
        this.ans = "";
        this.root = new Node();
        for (String word : words) {
            buildTire(word);
        }
        return ans;
    }
}
```