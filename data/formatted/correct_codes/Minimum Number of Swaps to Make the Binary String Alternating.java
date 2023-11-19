class Solution {
    public int minSwaps(String s) {
        int cntZero = 0, cntOne = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') cntZero++;
            else cntOne++;
        }
        if (Math.abs(cntOne - cntZero) > 1) return - 1;


        if (cntOne > cntZero) {
            return countSwaps(s, '1');
        } else if (cntOne < cntZero) {
            return countSwaps(s, '0');
        }

        return Math.min(countSwaps(s, '0'), countSwaps(s, '1'));
    }

    private int countSwaps(String s, char start) {
        int wrongPosition = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != start) wrongPosition++;
        }
        return wrongPosition;
    }
} 
