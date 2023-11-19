class Solution {
    public boolean checkOnesSegment(String s) {
        return ! s.contains("01") && ! s.contains("1");
    }
}