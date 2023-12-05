```java
class TrieNode {
    TrieNode[] childs;
    int frequency;

    TrieNode() {
        childs = new TrieNode[26];
        this.frequency = 0;
    }
}

class Solution {

    TrieNode root = new TrieNode();

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        for (String str : strs) {
            insertIntoTrie(str.toLowerCase());
        }
        return findCommonPrefix(strs[0], strs.length);
    }

    private void insertIntoTrie(String str) {
        TrieNode ptr = root;
        for (int i = 0; i < str.length(); i++) {
            if (ptr.childs[str.charAt(i) - 'a'] == null) {
                ptr.childs[str.charAt(i) - 'a'] = new TrieNode();
            }
            ptr = ptr.childs[str.charAt(i) - 'a'];
            ptr.frequency++;
        }
    }

    private String findCommonPrefix(String str, int n) {
        StringBuilder prefix = new StringBuilder();        
        TrieNode ptr = root;
        for (int i = 0; i < str.length(); i++) {
            if (ptr.frequency != n) {
                return prefix.toString();
            }
            prefix.append(str.charAt(i));
            ptr = ptr.childs[str.charAt(i) - 'a'];
        }
        return prefix.toString();
    }
}
```