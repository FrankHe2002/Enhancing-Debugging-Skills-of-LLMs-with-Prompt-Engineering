```java
// Runtime: 57 ms (Top 15.7%) | Memory: 54.11 MB (Top 92.9%)

class Solution {
    public String decodeCiphertext(String str, int rows) {
        // first find column size
        int cols = (str.length() + rows - 1) / rows;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            // iterating diagonally
            for (int j = i; j < str.length(); j += cols) {
                res.append(str.charAt(j));
            }
        }

        // removing trailing spaces
        return res.toString().replaceAll("\\s+$", "");
    }
}
```