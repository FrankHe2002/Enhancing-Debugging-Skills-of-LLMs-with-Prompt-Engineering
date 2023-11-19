// Runtime: 12 ms (Top 50.35%) | Memory: 39.4 MB (Top 54.17%)
class Solution {
    public String reverseWords(String s) {
        if(s == null || s.trim().equals("")){
            return "";
        }
        String [] words = s.split(" ");
        StringBuilder resultBuilder = new StringBuilder();
        for(String word: words){
            for(int i = word.length() - 1; i>=0; i --){
                resultBuilder.append(word.charAt(i));
            }
            resultBuilder.append(" ");
        }
        return resultBuilder.toString().trim();
    }
}