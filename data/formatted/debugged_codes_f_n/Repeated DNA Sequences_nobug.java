```java
// Runtime: 25 ms (Top 32.13%) | Memory: 47.4 MB (Top 60.91%)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int k = 10;
        StringBuilder sb = new StringBuilder();
        
        while (j < s.length()) {
            sb.append(s.charAt(j));
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                String sequence = sb.toString();
                map.put(sequence, map.getOrDefault(sequence, 0) + 1);
                sb.deleteCharAt(0);
                i++;
                j++;
            }
        }
        
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> mapElement : map.entrySet()) {
            if (mapElement.getValue() > 1) {
                list.add(mapElement.getKey());
            }
        }
        
        return list;
    }
}
```