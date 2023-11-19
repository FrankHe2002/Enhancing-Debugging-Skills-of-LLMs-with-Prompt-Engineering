class Solution {
    public String reversePrefix(String word, char ch) {
        char[] c = word.toCharArray();
        int locate = - 1;
        for (int i = 0; i < word.length(); i++) {
            if (ch == c[i]) {
                locate = i;
                break;
            }
        }
        if (locate != - 1) {
            for (int i = 0; i <= locate / 2; i++) {
                char temp = c[i];
                c[i] = c[locate - i];
                c[locate - i] = temp;
            }
        }
        return String.valueOf(c);
    }
}