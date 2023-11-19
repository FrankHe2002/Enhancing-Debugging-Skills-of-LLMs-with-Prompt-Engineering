class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) s = gen(s, k);
        return s;
    }

    public String gen(String s, int k) {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < s.length(); ) {
            int count = 0, num = 1;
            while (i < s.length() && count++ < k)
                num *= Character.getNumericValue(s.charAt(i++));
            res.append(num);
        }
        return res.toString();
    }
}