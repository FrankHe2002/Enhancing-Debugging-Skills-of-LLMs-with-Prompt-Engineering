// Runtime: 0 ms (Top 100.00%) | Memory: 37.2 MB (Top 92.12%)
class Solution {
    public String reversePrefix(String word, char ch) {
        char[] c = word.toCharArray();
        int locate = -1;
        for (int i = 0; i < word.length(); i++) { //first occurance of ch
            if (ch == c[i]) {
                locate = i;
                break;
            }
        }
        if (locate != -1) {
            for (int i = 0; i <= locate / 2; i++) {
                char temp = c[i];
                c[i] = c[locate - i];
                c[locate - i] = temp;
            }
        }
        return String.valueOf(c);
    }
}