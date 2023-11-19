```java
class Solution {
    public int[] groupStrings(String[] words) {
        int n = words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] parents = new int[n];
        int[] ranks = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;
        Arrays.fill(ranks, 1);

        int[][] masks = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                masks[i][j] = words[i].charAt(j);
            }
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (seen.contains(i)) continue;
            for (int j = i + 1; j < n; j++) {
                if (words[i].length() + 1 < words[j].length()) break;
                int p1 = find(parents, i), p2 = find(parents, j);
                if (p1 == p2) continue;
                int[] a = masks[i], b = masks[j];
                if (Arrays.equals(a, b)) merge(parents, ranks, p1, p2);
                int[] xor = new int[26];
                int[] and = new int[26];
                for (int k = 0; k < 26; k++) {
                    xor[k] = a[k] ^ b[k];
                    and[k] = a[k] & b[k];
                }
                int[] xor1 = new int[26];
                int[] xor2 = new int[26];
                for (int k = 0; k < 26; k++) {
                    xor1[k] = a[k] ^ and[k];
                    xor2[k] = b[k] ^ and[k];
                }
                if (isPowerOfTwo(xor) || (isPowerOfTwo(xor1) && isPowerOfTwo(xor2))) {
                    merge(parents, ranks, p1, p2);
                }
            }
            seen.add(i);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0; i < n; i++) {
            int f = find(parents, i);
