class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (int i = 0; i < sentences.length; i++) {
            max = Math.max(max, (sentences[i].trim().split("\\s+")).length);
        }
        return max;
    }
}