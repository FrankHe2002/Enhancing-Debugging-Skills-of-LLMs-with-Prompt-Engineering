// Runtime: 0 ms (Top 100%) | Memory: 37.3 MB (Top 24.25%)
class Solution {
    public String generateTheString(int n) {
        String s = "";
        String string ="a";
        for (int i = 0; i < n-1; i++) {
            s += string;
        }
        if(n%2==0) {
            return s + "b";
        }
        return s + "a";
    }
}