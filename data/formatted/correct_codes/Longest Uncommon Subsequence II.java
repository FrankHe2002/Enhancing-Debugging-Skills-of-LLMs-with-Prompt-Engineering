class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> b.length() - a.length());
        Map<String, Integer> map = new HashMap<>();
        for (String s : strs) map.put(s, map.getOrDefault(s, 0) + 1);

        for (int i = 0; i < strs.length; i++) {
            if (map.get(strs[i]) != 1) continue;
            int j;
            for (j = 0; j < i; j++) {
                if (isSubsequence(strs[i], strs[j])) break;
            }
            if (j == i) return strs[i].length();
        }
        return - 1;
    }

    public boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length())
            if (a.charAt(i) == b.charAt(j++)) i++;
        return i == a.length();
    }
}