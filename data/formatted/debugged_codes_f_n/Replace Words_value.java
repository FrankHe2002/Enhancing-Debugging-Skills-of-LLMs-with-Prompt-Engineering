```java
class Solution {
    class trii {
        char data;
        trii[] dict;
        boolean isTerminal;

        trii() {
            dict = new trii[26];
            isTerminal = false;
        }
    }

    class tree {
        trii root;

        tree() {
            root = new trii();
        }

        void insert(String str, trii node) {
            if (str.length() == 0) {
                node.isTerminal = true;
                return;
            }
            int index = str.charAt(0) - 'a';
            if (node.dict[index] == null) {
                node.dict[index] = new trii();
            }
            insert(str.substring(1), node.dict[index]);
        }

        String find(String str, trii node, String pre) {
            if (node.isTerminal) {
                return pre;
            }
            int index = str.charAt(0) - 'a';
            if (str.length() == 0 || node.dict[index] == null) {
                return "\0";
            }
            return find(str.substring(1), node.dict[index], pre + str.charAt(0));
        }

        String replaceWith(String word, trii node) {
            String temp = find(word, node, "");
            if (!"\0".equals(temp)) {
                word = temp;
            }
            return word;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        tree t = new tree();
        for (int i = 0; i < dictionary.size(); i++) {
            t.insert(dictionary.get(i), t.root);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            String word = "";
            while (i < sentence.length() && sentence.charAt(i) != ' ') {
                word += sentence.charAt(i);
                i++;
            }

            sb.append(t.replaceWith(word, t.root)).append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
```