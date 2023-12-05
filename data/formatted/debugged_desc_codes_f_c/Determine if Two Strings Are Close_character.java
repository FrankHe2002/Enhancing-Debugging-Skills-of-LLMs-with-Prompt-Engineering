```java
// Runtime: 24 ms (Top 51.63%) | Memory: 58.9 MB (Top 49.30%)
class Solution {
    private int N = 26;

    public boolean closeStrings(String word1, String word2) {
        // count the English letters
        int[] arr1 = new int[N], arr2 = new int[N];
        for (char ch : word1.toCharArray())
            arr1[ch - 'a']++;
        for (char ch : word2.toCharArray())
            arr2[ch - 'a']++;
        
        // Sort the arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Check if all entries are identical
        for (int i = 0; i < N; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
}
```