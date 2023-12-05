```java
class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        HashMap<Integer, String> subst = new HashMap<>();
        HashMap<Integer, String> tgt = new HashMap<>();

        for (int i = 0; i < indices.length; i++) {
            subst.put(indices[i], sources[i]);
            tgt.put(indices[i], targets[i]);
        }

        Arrays.sort(indices);

        StringBuilder res = new StringBuilder("");
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count < indices.length && i == indices[count] && s.indexOf(subst.get(indices[count]), indices[count]) == indices[count]) {
                res.append(tgt.get(indices[count]));
                i = i + subst.get(indices[count]).length() - 1;
                count++;
            } else {
                if (count < indices.length && i == indices[count])
                    count++;
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }
}
```