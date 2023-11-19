class Solution {
    public int maximum69Number(int num) {
        int i;
        String s = String.valueOf(num);
        int l = s.length();
        int max = num;

        for (i = 0; i < l; i++) {
            char[] c = s.toCharArray();
            if (c[i] == '6') {
                c[i] = '9';
            } else {
                c[i] = '6';
            }
            String p = new String(c);
            int k = Integer.parseInt(p);
            max = Math.max(max, k);
        }
        return max;
    }
}