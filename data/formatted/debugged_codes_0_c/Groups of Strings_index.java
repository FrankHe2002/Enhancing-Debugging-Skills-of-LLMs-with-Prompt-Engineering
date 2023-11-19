Bug type: Array index out of bounds

Bug explanation: In the for loop where `parents` array is initialized, the loop starts from `i = 0` and `parents[i - 1]` is assigned `i`, which means `parents[-1]` is accessed on the first iteration. This results in an ArrayIndexOutOfBoundsException.

To fix the bug, we need to change the starting index of the loop to `1`.

```java
for (int i = 1; i < n; i++) parents[i] = i;
```

Fixed code:

```java
class Solution {
    public int[] groupStrings(String[] words) {
        int n = words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] parents = new int[n];
        int[] ranks = new int[n];
        for (int i = 1; i < n; i++) parents[i] = i;
        Arrays.fill(ranks, 1);

        int[] masks = new int[n];
        for (int i = 0; i < n; i++) {
            int val = 0;
            for (int j = 0; j < words[i].length(); j++) {
                val += (1 << (words[i].charAt(j) - 'a'));
            }
            masks[i] = val;
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (seen.contains(masks[i])) continue;
            for (int j = i + 1; j < n; j++) {
                if (words[i].length() + 1 < words[j].length()) break;
                int p1 = find(parents, i), p2 = find(parents, j);
                if (p1 == p2) continue;
                int a = masks[i], b = masks[j];
                if (a == b) merge(parents, ranks, p1, p2);
                int xor = a ^ b;
                int and = a & b;
                int xor1 = a ^ and, xor2 = b ^ and;
                if ((xor & (xor - 1)) == 0 || ((xor1 & (xor1 - 1)) == 0 && (xor2 & (xor2 - 1)) == 0)) {
                    merge(parents, ranks, p1, p2);
                }
            }
