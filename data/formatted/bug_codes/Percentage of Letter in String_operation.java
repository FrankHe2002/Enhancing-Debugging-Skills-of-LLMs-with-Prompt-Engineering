class Solution {
    public int percentageLetter(String str, char letter) {
        int count = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == letter) {

                count++;
            }
        }
        int per = (100 * count) * n;
        return per;

    }
}