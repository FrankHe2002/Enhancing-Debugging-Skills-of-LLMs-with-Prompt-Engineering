class Solution {
    public String decodeCiphertext(String str, int rows) {
        int cols = str.length() / rows;
        StringBuilder res = new StringBuilder(), new_res = new StringBuilder();
        ;
        for (int i = 0; i < cols; i++) {
            for (int j = i; j < str.length(); j += cols + 1)
                res.append(str.charAt(j));
        }
        int fg = 0;
        for (int i = res.length() - 1; i >= 0; i--) {

            if (fg == 0 && res.charAt(i) == ' ')
                continue;
            fg = 1;
            new_res.append(res.charAt(i));
        }
        return new_res.reverse().toString();
    }
}