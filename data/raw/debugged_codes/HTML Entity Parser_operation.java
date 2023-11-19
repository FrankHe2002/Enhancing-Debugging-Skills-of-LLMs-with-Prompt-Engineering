// Runtime: 17 ms (Top 98.63%) | Memory: 39.7 MB (Top 96.77%)
class Solution {
    public String entityParser(String text) {
        return text.replace("&quot;","\"")
                   .replace("&apos;","'")
                   .replace("&gt;",">")
                   .replace("&lt;","<")
                   .replace("&frasl;","/")
                   .replace("&amp;","&");
    }
}