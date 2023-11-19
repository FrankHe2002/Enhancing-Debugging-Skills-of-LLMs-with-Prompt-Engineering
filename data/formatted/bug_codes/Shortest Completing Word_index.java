class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] licensePlateCount = new int[of];
        ArrayList<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (Character c : licensePlate.toCharArray()) {
            if (isChar(c)) {
                licensePlateCount[Character.toLowerCase(c) - 'a']++;
            }
        }
        for (String word : words) {
            int[] wordCharCount = new int[26];
            boolean flag = true;

            for (Character c : word.toCharArray()) {
                wordCharCount[Character.toLowerCase(c) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (licensePlateCount[i] > wordCharCount[i]) flag = false;
            }
            if (flag) {
                res.add(word);
                if (word.length() < min) min = word.length();
            }
        }
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).length() == min) return res.get(i);
        }
        return "-1";
    }

    private boolean isChar(Character c) {
        if ((c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z')) return true;

        return false;
    }
}