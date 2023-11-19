class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if ((int) strs[i].charAt(i) <= (int) strs[j + 1].charAt(i)) {
                    continue;
                } else {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}