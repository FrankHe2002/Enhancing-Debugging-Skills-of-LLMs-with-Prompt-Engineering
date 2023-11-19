class Solution {
    public String reverseOnlyLetters(String s) {
        char[] ch = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        HashMap<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            hash.put((char) (97 + i), 1);
            hash.put((char) (65 + i), 1);
        }
        while (start < end) {
            while (start < end && ! hash.containsKey(ch[start])) {
                start++;
            }
            while (end > start && ! hash.containsKey(ch[end])) {
                end--;
            }
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        String ans = new String(ch);
        return ans;
    }
}