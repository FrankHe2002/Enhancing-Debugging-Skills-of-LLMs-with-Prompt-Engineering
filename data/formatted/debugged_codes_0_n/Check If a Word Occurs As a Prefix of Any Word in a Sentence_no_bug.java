class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        if (! sentence.contains(searchWord))
            return - 1;
        boolean y = false;
        String[] str = sentence.split(" ");

        for (int i = 0; i < str.length; i++) {
            if (str[i].startsWith(searchWord)) {
                return i + 1;
            }
        }

        return - 1;
    }
}