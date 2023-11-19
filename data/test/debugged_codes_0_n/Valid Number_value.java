class Solution {
    public boolean isNumber(String s) {
        try {
            int l = s.length();
            if (s.equals("Infinity") || s.equals("-Infinity") || s.equals("+Infinity") || s.charAt(l - 1) == 'f'
                    || s.charAt(l - 1) == 'd' || s.charAt(l - 1) == 'D' || s.charAt(l - 1) == 'F' || s.charAt(0) == ' ')
                return false;
            double x = Double.parseDouble(s.trim());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}