```java
// Runtime: 6 ms (Top 87.18%) | Memory: 42.6 MB (Top 46.17%)
class Solution {

    private final TrieNode trie = new TrieNode(' ');

    class TrieNode {

        private Character digit;
        private String value;
        private boolean isWord;
        private Map<Character, TrieNode> children;

        TrieNode(Character c) {
            this.digit = c;
            this.isWord = false;
            this.children = new HashMap<>();
        }

        void insert(String s) {
            TrieNode current = this;
            for (Character c : s.toCharArray()) {
                current = current.children.computeIfAbsent(c, k -> new TrieNode(c));
            }
            current.value = s;
            current.isWord = true;
        }

        List<Integer> getWordsPreOrder() {
            return getWordsPreOrder(this);
        }

        private List<Integer> getWordsPreOrder(TrieNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            if (root.isWord) {
                result.add(Integer.parseInt(root.value));
            }
            List<TrieNode> nodes = new ArrayList<>(root.children.values());
            Collections.sort(nodes, (a, b) -> {
                int aVal = Integer.parseInt(a.value);
                int bVal = Integer.parseInt(b.value);
                return aVal - bVal;
            });
            for (TrieNode node : nodes) {
                result.addAll(getWordsPreOrder(node));
            }
            return result;
        }
    }

    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= n; i++) {
            trie.insert(String.valueOf(i));
        }
        return trie.getWordsPreOrder();
    }
}
```