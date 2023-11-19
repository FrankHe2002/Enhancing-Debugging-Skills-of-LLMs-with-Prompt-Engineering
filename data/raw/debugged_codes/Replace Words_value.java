class Solution {
    class trii {
        char data;
        trii* dict[26];
        boolean isTerminal;

        trii() {

        }

        trii(char d) {
            data = d;
            for (int i = 0; i < 26; i++) {
                dict[i] = null;
            }
            isTerminal = false;
        }
    }

    class tree {
        trii* root;

        tree() {
            root = new trii('\0');
        }

        void insert(String str, trii* node) {
            if (str.length() == 0) {
                node->isTerminal = true;
                return;
            }
            int index = str.charAt(0) - 'a';
            if (node->dict[index] == null) {
                node->dict[index] = new trii(str.charAt(0));
            }
            insert(str.substring(1), node->dict[index]);
        }

        String find(String str, trii* node, String pre) {
            if (node->isTerminal == true) {
                return pre;
            }
            int index = str.charAt(0) - 'a';
            if (str.length() == 0 || node->dict[index] == null) {
                return "\0";
            }
            return find(str.substring(1), node->dict[index], pre + str.charAt(0));
        }

        String replaceWith(String word, trii* node) {
            String temp = find(word, node, "");
            if (!temp.equals("\0")) {
                word = temp;
            }
            return word;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        tree* t = new tree();
        for (int i = 0; i < dictionary.size(); i++) {
            t->insert(dictionary.get(i), t->root);
        }
        String ans = sentence;
        sentence = "";
        for (int i = 0; i < ans.length(); i++) {
            String word = "";
            while (i < ans.length() && ans.charAt(i) != ' ') {
                word += ans.charAt(i);
                i++;
            }

            sentence += t->replaceWith(word, t->root) + " ";
        }
        sentence = sentence.substring(0, sentence.length() - 1);
        return sentence;
    }
}