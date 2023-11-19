class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if ((int) strs[j].charAt(i) > (int) strs[j + 1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}