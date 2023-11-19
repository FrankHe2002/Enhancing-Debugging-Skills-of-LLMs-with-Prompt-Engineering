class Solution {
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            if (! s.contains(toBinary(i))) {
                return false;
            }
        }
        return true;
    }

    public String toBinary(int n) {
        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            int r = n % 2;
            binary.insert(0, r);
            n = n / 2;
        }
        return binary.toString();
    }
}