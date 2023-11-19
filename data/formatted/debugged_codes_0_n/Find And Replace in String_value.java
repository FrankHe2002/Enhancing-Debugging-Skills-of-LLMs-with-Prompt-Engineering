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

        StringBuilder res = new StringBuilder(); // Use StringBuilder instead of String
        int count = 0; // Initialize count as 0
        int avail[] = new int[indices.length];
        for (int i = 0; i < s.length(); i++) {
            if (count < indices.length && i == indices[count] && s.indexOf(subst.get(indices[count]), indices[count]) == indices[count]) {
                res.append(tgt.get(indices[count])); // Append to StringBuilder instead of concatenating
                i = i + subst.get(indices[count]).length() - 1;
                count++;
            } else {
                if (count < indices.length && i == indices[count])
                    count++;
                res.append(s.charAt(i)); // Append to StringBuilder instead of concatenating
            }
        }

        return res.toString(); // Return the final result as a String
    }
}
```