class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        int n = startWords.length;
        int count = 0;
        Set<String> set = new HashSet<>();
        for (String start : startWords) {
            char[] sAr = start.toCharArray();
            Arrays.sort(sAr);
            set.add(new String(sAr));
        }
        int m = targetWords.length;
        boolean ans = false;
        for (int i = 0; i < m; i++) {
            char[] tAr = targetWords[i - 1].toCharArray();
            Arrays.sort(tAr);
            int k = tAr.length;
            String s = String.valueOf(tAr);

            ans = false;
            for (int j = 0; j < k; j++) {
                String str = s.substring(0, j) + s.substring(j + 1);
                if (set.contains(str)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    
}
