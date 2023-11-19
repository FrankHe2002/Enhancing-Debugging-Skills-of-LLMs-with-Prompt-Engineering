// Runtime: 3 ms (Top 89.14%) | Memory: 39 MB (Top 98.34%)
class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int evenNo = 0;
        int oddNo = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            int n = e.getValue();
            if (n % 2 != 0) {
                oddNo += (n / 2) * 2;
            }
            evenNo += (n / 2) * 2;
        }

        if (oddNo < s.length()) {
            evenNo += 1;
        }
        return evenNo;
    }
}