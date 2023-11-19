class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    res = res + 1;
                    break;
                case 'V':
                    res = res + 5;
                    break;
                case 'X':
                    res += 10;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }
        if (s.contains("IV") || s.contains("IX"))
            res = res - 2;
        if (s.contains("XL") || s.contains("XC"))
            res = res - 20;
        if (s.contains("CD") || s.contains("CM"))
            res = res - 200;

        return res;
    }
}