class Solution {

    private TrieNode trie = new TrieNode(' ');

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
                TrieNode newNode = current.children.get(c);
                if (newNode == null) {
                    newNode = new TrieNode(c);
                    current.children.put(c, newNode);
                }
                current = newNode;
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
            for (TrieNode node : root.children.values()) {
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