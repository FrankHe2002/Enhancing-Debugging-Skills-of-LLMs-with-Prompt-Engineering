class Solution {
    public boolean strongPasswordCheckerII(String password) {
        HashSet<Integer> intAscii = new HashSet<>();
        String specialCharacters = "!@#$%^&*()-+";
        for (int i = 0; i < specialCharacters.length(); i++) {
            int ascii = specialCharacters.charAt(i);
            intAscii.add(ascii);
        }
        
        if (password.length() < 8) {
            return false;
        }
        boolean small = false;
        boolean large = false;
        boolean numbers = false;
        boolean specialChars = false;
        for (int i = 0; i < password.length(); i++) {
            int ascii = (int)(password.charAt(i));
            if (ascii >= 65 && ascii <= 90) {
                large = true;
            }
            if (ascii >= 97 && ascii <= 122) {
                small = true;
            }
            if (ascii >= 48 && ascii <= 57) {
                numbers = true;
            }
            if (intAscii.contains(ascii)) {
                specialChars = true;
            }
            if (i > 1 && password.charAt(i) == password.charAt(i - 2)) {
                return false;
            }
        }
        if (!large || !small || !numbers || !specialChars) {
            return false;
        }
        return true;
    }
}