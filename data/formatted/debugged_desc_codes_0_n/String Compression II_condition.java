```java
class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        Map<String, Integer> memo = new HashMap<>();
        return recur(s, '\u0000', 0, k, 0, memo);
    }

    private int recur(String s, char prevChar, int prevCharCount, int k, int index, Map<String, Integer> memo) {

        if (index == s.length()) {
            return 0;
        }
        String key = prevChar + ", " + prevCharCount + ", " + k + ", " + index;
        Integer keyVal = memo.get(key);

        if (keyVal != null) {
            return keyVal;
        }
        char ch = s.charAt(index);
        int count = 1;
        int nextIndex = index + 1;

        for (int i = index + 1; i < s.length(); i++) {

            if (s.charAt(i) == ch && k > 0) {
                count++;
                nextIndex = i + 1;
                k--; // decrease k when removing consecutive identical characters
            } else if (s.charAt(i) == ch && k == 0) {
                nextIndex = i + 1;
            } else {
                nextIndex = i;
                break;
            }
        }
        int totalCount = count;
        int prevCountRepresentation = 0;
        //if prev char is equal to current char that means we have removed middle element
        //So we have to subtract the previous representation length and add the new encoding
        //representation length
        if (ch == prevChar) {
            totalCount += prevCharCount;
            prevCountRepresentation = getLength(prevCharCount);
        }

        int representaionLength = getLength(totalCount);
        int ans = representaionLength + recur(s, ch, totalCount, k, nextIndex, memo) - prevCountRepresentation;

        memo.put(key, ans);
        return ans;
    }

    //Since length for aaaaa will be a5(2) aaaaaaaaaa a10(3) etc.
    private int getLength(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n < 10) {
            return 2;
        } else if (n < 100) {
            return 3;
        } else {
            return 4;
        }
    }
}
```