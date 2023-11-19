Bug type: Index out of bounds

Reasoning:
1. In the `query` method, the for loop is iterating from `sb.length() - 1` to 0, but the condition `i < 0` is incorrect. It should be `i >= 0`.
2. Because of this incorrect condition, the loop condition `i < 0` is always false, resulting in the loop not executing at all. As a result, the method returns `false` regardless of the input.

Fix:
Change the loop condition in the `query` method to `i >= 0`.

```java
public boolean query(char letter) {
    sb.append(letter);
    TrieNode node = root;
    for (int i = sb.length() - 1; i >= 0 && node != null; i--) {
        char ch = sb.charAt(i);
        node = node.next[ch - 'a'];
        if (node != null && node.isWord) {
            return true;
        }
    }
    return false;
}
```