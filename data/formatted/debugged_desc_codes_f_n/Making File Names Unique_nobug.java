```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public String[] getFolderNames(String[] names) {
        String[] op = new String[names.length];
        int i = 0;
        
        for (String cur : names) {
            if (map.containsKey(cur)) {
                cur = generateCopyName(cur);
                op[i++] = cur;
                continue;
            }
            
            op[i++] = cur;
            map.put(cur, 0);
        }
        
        return op;
    }
    
    private String generateCopyName(String s) {
        int count = map.getOrDefault(s, 0) + 1;
        
        String postfix = "(" + count + ")";
        StringBuilder sb = new StringBuilder(s);
        sb.append(postfix);
        
        while (map.containsKey(sb.toString())) {
            count++;
            sb = new StringBuilder(s);
            sb.append("(" + count + ")");
        }
        
        String res = sb.toString();
        
        map.put(s, count);
        map.put(res, 0);
        
        return res;
    }
}
```