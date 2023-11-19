```java
// Runtime: 10 ms (Top 50.64%) | Memory: 41.9 MB (Top 93.63%)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        for (String s : strs) {
            char ch[] = s.toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);
            if (hm.containsKey(str)) {
                ArrayList<String> temp = hm.get(str);
                temp.add(s);
                hm.put(str, temp);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(s);
                hm.put(str, temp);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (ArrayList<String> arr : hm.values()) {
            res.add(arr);
        }
        return res;
    }
}
```