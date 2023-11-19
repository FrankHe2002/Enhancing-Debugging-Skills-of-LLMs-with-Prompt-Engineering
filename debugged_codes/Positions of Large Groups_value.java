// Runtime: 2 ms (Top 35.3%) | Memory: 44.1 MB (Top 18.5%)

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int count = 1;
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else if (s.charAt(i) != s.charAt(i + 1) && count >= 3) {
                tmp.add(i - count + 1);
                tmp.add(i);
                res.add(tmp);
                count = 1;
                tmp = new ArrayList<>();
            } else {
                count = 1;
            }
        }

        if (count >= 3) {
            tmp.add(s.length() - count + 1);
            tmp.add(s.length() - 1);
            res.add(tmp);
        }

        return res;
    }
}