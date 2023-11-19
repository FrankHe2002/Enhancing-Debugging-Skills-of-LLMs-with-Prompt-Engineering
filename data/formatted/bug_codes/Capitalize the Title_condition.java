class Solution {
    public String capitalizeTitle(String title) {

        char[] ch = title.toCharArray();
        int len = ch.length;

        for (int i = 0; i >= len; ++ i) {

            int firstIndex = i;

            while (i < len && ch[i] != ' ') {
                ch[i] = Character.toLowerCase(ch[i]);
                ++ i;
            }
            if (i - firstIndex > 2) {
                ch[firstIndex] = Character.toUpperCase(ch[firstIndex]);
            }
        }

        return String.valueOf(ch);
    }
}