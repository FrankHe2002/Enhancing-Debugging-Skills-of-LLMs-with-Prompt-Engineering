```java
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {

        class Trie {
            char data;
            Trie[] dict;
            boolean isTerminal;

            Trie() {
                dict = new Trie[26];
            }

            Trie(char d) {
                this.data = d;
                this.dict = new Trie[26];
                this.isTerminal = false;
            }
        }

        class Tree {
            Trie root;

            Tree() {
                root = new Trie('\0');
            }

            void insert(String str, Trie node) {
                if (str.isEmpty()) {
                    node.isTerminal = true;
                    return;
                }
                int index = str.charAt(0) - 'a';
                if (node.dict[index] == null) {
                    node.dict[index] = new Trie(str.charAt(0));
                }
                insert(str.substring(1), node.dict[index]);
            }

            String find(String str, Trie node, String pre) {
                if (node.isTerminal) {
                    return pre;
                }
                if (str.isEmpty() || node.dict[str.charAt(0) - 'a'] == null) {
                    return "\0";
                }
                return find(str.substring(1), node.dict[str.charAt(0) - 'a'], pre + str.charAt(0));
            }

            String replaceWith(String word, Trie node) {
                String temp = find(word, node, "");
                if (!temp.equals("\0")) {
                    word = temp;
                }
                return word;
            }
        }

        Tree t = new Tree();
        for (String s : dictionary) {
            t.insert(s, t.root);
        }
        String[] words = sentence.split(" ");
        StringBuilder replaced = new StringBuilder();
        for (String word : words) {
            replaced.append(t.replaceWith(word, t.root)).append(" ");
        }
        if (replaced.length() > 0) {
            replaced.setLength(replaced.length() - 1); // Remove the extra space at the end
        }
        return replaced.toString();
    }
}
```