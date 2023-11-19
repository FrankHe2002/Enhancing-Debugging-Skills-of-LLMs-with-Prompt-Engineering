// Runtime: 6 ms (Top 63.70%) | Memory: 39.1 MB (Top 98.08%)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hash = new HashMap<>();
        int count = 0;
        int ans = 0;
        for(int i=0; i < s.length(); i++){
            if(hash.containsKey(s.charAt(i))){
                i = hash.get(s.charAt(i));
                hash.clear();
                count = 0;
            }
            if(!hash.containsKey(s.charAt(i))){
                hash.put(s.charAt(i), i+1);
                count++;
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}