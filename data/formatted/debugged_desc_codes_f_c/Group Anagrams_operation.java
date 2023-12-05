```Java
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        for (String s : strs) {
            char ch[] = s.toCharArray();
            Arrays.sort(ch);
            String str = String.valueOf(ch);
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
        List<List<String>> res = new ArrayList<>(hm.values());
        return res;
    }
}
```