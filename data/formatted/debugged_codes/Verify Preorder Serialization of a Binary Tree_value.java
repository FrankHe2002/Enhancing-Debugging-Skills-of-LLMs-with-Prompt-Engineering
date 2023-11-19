class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        int vacancy = 1;

        for (String str : strs) {

            if (-- vacancy < 0) return false;

            if (! str.equals("#"))
                vacancy += 2;

        }

        return vacancy == 0;

    }
}