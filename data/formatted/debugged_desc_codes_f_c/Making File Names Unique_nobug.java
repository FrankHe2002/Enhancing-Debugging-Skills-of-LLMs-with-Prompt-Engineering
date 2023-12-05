```java
class Solution {
    Map<String, Integer> map = new HashMap<>();

    public String[] getFolderNames(String[] names) {
        String[] op = new String[names.length];
        int i = 0;

        for (String cur : names) {
            if (map.containsKey(cur)) {
                cur = generateCopyName(cur, map);
                op[i++] = cur;
                continue;
            }

            op[i++] = cur;
            map.put(cur, 0);
        }

        return op;
    }

    private String generateCopyName(String s, Map<String, Integer> map) {
        int count = map.get(s) + 1;

        String postfix = "(" + count + ")";
        StringBuilder sb = new StringBuilder(s);
        sb.append(postfix);

        boolean isChanged = false;
        while (map.containsKey(sb.toString())) {
            sb = new StringBuilder(s);
            sb.append("(" + count + ")");
            count++;
            isChanged = true;
        }
        String res = sb.toString();

        if (isChanged)
            count = count - 1;

        map.put(s, count);
        map.put(res, 0);

        return res;
    }
}
```