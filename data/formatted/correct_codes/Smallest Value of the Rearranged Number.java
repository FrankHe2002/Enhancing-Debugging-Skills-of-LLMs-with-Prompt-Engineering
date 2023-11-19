class Solution {
    public long smallestNumber(long num) {
        if (num == 0) {
            return 0;
        }
        boolean isNegative = num < 0;
        num = num < 0 ? num * - 1 : num;

        char[] c = String.valueOf(num).toCharArray();
        Arrays.sort(c);
        String str;
        if (! isNegative) {
            int non = 0;
            for (; non < c.length; non++) {
                if (c[non] != '0') {
                    break;
                }
            }
            char temp = c[non];
            c[non] = c[0];
            c[0] = temp;
            str = new String(c);
        } else {
            str = new String(c);
            StringBuilder sb = new StringBuilder(str);
            str = "-".concat(sb.reverse().toString());
        }
        return Long.valueOf(str);
    }
}
